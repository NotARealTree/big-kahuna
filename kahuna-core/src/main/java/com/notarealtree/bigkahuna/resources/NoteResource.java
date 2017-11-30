package com.notarealtree.bigkahuna.resources;

import com.notarealtree.bigkahuna.model.NoteId;
import com.notarealtree.bigkahuna.s3.S3Connector;
import com.notarealtree.bigkahuna.services.DocumentService;
import com.notarealtree.bigkahuna.services.NoteService;

import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

public class NoteResource implements NoteService {
    private final S3Connector s3Connector;

    @Inject
    public NoteResource(S3Connector s3Connector) {
        this.s3Connector = s3Connector;
    }

    @Override
    public NoteId addNote(String text) {
        return NoteId.builder().id(s3Connector.addNote(text)).build();
    }

    @Override
    public void updateNote(String id, String text) {
        s3Connector.putNote(id, text);
    }

    @Override
    public Set<NoteId> getNotes() {
        return s3Connector.previewNotes().stream()
                .map(noteId -> NoteId.builder().id(noteId).build())
                .collect(Collectors.toSet());
    }

    @Override
    public String getNote(NoteId id) {
        return s3Connector.getNote(id);
    }
}
