/*
 * (c) Copyright 2017 Palantir Technologies Inc. All rights reserved.
 */

package com.notarealtree.bigkahuna.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutablePartialDocument.class)
@JsonDeserialize(as = ImmutablePartialDocument.class)
public interface PartialDocument {
    String title();
    String content();

    static ImmutablePartialDocument.Builder builder() {
        return ImmutablePartialDocument.builder();
    }
}
