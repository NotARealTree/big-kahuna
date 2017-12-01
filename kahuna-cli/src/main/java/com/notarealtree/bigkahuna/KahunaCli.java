package com.notarealtree.bigkahuna;

import com.notarealtree.bigkahuna.model.DocumentId;
import com.notarealtree.bigkahuna.model.NoteId;
import com.notarealtree.bigkahuna.model.PartialDocument;
import com.notarealtree.bigkahuna.services.KahunaService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.Scanner;

public class KahunaCli {
    private Scanner scanner = new Scanner(System.in);
    private final KahunaService kahunaService;

    private KahunaCli() {
        this.kahunaService = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(KahunaService.class, "http://localhost:8080");
    }

    public static void main(String[] args) {
        new KahunaCli().run();
    }

    private void run() {
        String input;
        while (true) {
            input = scanner.nextLine();
            handleInput(input);
        }
    }

    private void handleInput(String input) {
        if (input.startsWith("ls notes")) {
            String notes = kahunaService.getNotes().stream()
                    .map(NoteId::id)
                    .reduce((i1, i2) -> String.format("%s\n%s", i1, i2)).get();
            System.out.println(notes);
        } else if (input.startsWith("add note")) {
            String note = input.substring("add note ".length());
            System.out.println(kahunaService.addNote(note).id());
        } else if (input.startsWith("get note")) {
            String noteId = input.substring("get note ".length());
            System.out.println(kahunaService.getNote(noteId));
        } else if (input.startsWith("delete note")) {
            String noteId = input.substring("delete note ".length());
            kahunaService.deleteNote(noteId);
        } else if (input.startsWith("add document")) {
            String[] docFragments = input.substring("add document ".length()).split(",");
            PartialDocument doc = PartialDocument.builder().title(docFragments[0]).content(docFragments[1]).build();
            DocumentId documentId = kahunaService.addDocument(doc);
            System.out.println(documentId);
        }
    }
}
