/*
 * (c) Copyright 2017 Palantir Technologies Inc. All rights reserved.
 */

package com.notarealtree.bigkahuna.resources;

import com.notarealtree.bigkahuna.model.Document;
import com.notarealtree.bigkahuna.model.DocumentId;
import com.notarealtree.bigkahuna.model.PartialDocument;
import com.notarealtree.bigkahuna.s3.S3Connector;
import com.notarealtree.bigkahuna.services.DocumentService;
import java.util.UUID;
import javax.inject.Inject;

public class DocumentResource implements DocumentService {
    private final S3Connector s3Connector;

    @Inject
    public DocumentResource(S3Connector s3Connector) {
        this.s3Connector = s3Connector;
    }

    @Override
    public DocumentId addDocument(PartialDocument partialDocument) {
        UUID documentUuid = new UUID(UUID.nameUUIDFromBytes("document".getBytes()).getMostSignificantBits(),
                UUID.randomUUID().getLeastSignificantBits());
        DocumentId documentId = DocumentId.valueOf(documentUuid.toString());
        Document document = Document.builder()
                .title(partialDocument.title())
                .content(partialDocument.content())
                .id(documentId)
                .build();
        s3Connector.addDocument(document);
        return documentId;
    }

    @Override
    public void updateDocument(String id, String text) {

    }

    @Override
    public Document getDocument(DocumentId id) {
        return s3Connector.getDocument(id);
    }
}
