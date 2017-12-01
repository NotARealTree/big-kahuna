/*
 * (c) Copyright 2017 Palantir Technologies Inc. All rights reserved.
 */

package com.notarealtree.bigkahuna.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDocument.class)
@JsonDeserialize(as = ImmutableDocument.class)
public interface Document {
    DocumentId id();
    String title();
    String content();

    static com.notarealtree.bigkahuna.model.ImmutableDocument.Builder builder() {
        return com.notarealtree.bigkahuna.model.ImmutableDocument.builder();
    }
}
