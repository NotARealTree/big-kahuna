package com.notarealtree.bigkahuna.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDocumentId.class)
@JsonDeserialize(as = ImmutableDocumentId.class)
public interface DocumentId {
    String id();

    static DocumentId valueOf(String id) {
        return DocumentId.builder().id(id).build();
    }

    static ImmutableDocumentId.Builder builder() {
        return ImmutableDocumentId.builder();
    }
}
