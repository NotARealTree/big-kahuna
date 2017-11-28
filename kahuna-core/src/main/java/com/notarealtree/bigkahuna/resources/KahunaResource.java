package com.notarealtree.bigkahuna.resources;

import com.notarealtree.bigkahuna.model.NoteId;
import com.notarealtree.bigkahuna.s3.S3Connector;
import com.notarealtree.bigkahuna.services.KahunaService;

import javax.inject.Inject;
import java.util.Set;

public class KahunaResource implements KahunaService {
    private final S3Connector s3Connector;

    @Inject
    public KahunaResource(S3Connector s3Connector) {
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
    public Set<String> getNotes() {
        return s3Connector.previewNotes();
    }

    @Override
    public String getNote(String id) {
        return s3Connector.getNote(id);
    }
}
