package com.notarealtree.bigkahuna.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableNoteId.class)
@JsonDeserialize(as = ImmutableNoteId.class)
public interface NoteId {
    String id();

    static NoteId valueOf(String id) {
        return NoteId.builder().id(id).build();
    }

    static ImmutableNoteId.Builder builder() {
        return ImmutableNoteId.builder();
    }
}
