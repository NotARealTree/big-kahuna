package com.notarealtree.bigkahuna.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link NoteId}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableNoteId.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "NoteId"})
@Immutable
@CheckReturnValue
public final class ImmutableNoteId implements NoteId {
  private final String id;

  private ImmutableNoteId(String id) {
    this.id = id;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public String id() {
    return id;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NoteId#id() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNoteId withId(String value) {
    if (this.id.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "id");
    return new ImmutableNoteId(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableNoteId} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableNoteId
        && equalTo((ImmutableNoteId) another);
  }

  private boolean equalTo(ImmutableNoteId another) {
    return id.equals(another.id);
  }

  /**
   * Computes a hash code from attributes: {@code id}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code NoteId} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("NoteId")
        .omitNullValues()
        .add("id", id)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements NoteId {
    @Nullable String id;
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @Override
    public String id() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableNoteId fromJson(Json json) {
    ImmutableNoteId.Builder builder = ImmutableNoteId.builder();
    if (json.id != null) {
      builder.id(json.id);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link NoteId} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NoteId instance
   */
  public static ImmutableNoteId copyOf(NoteId instance) {
    if (instance instanceof ImmutableNoteId) {
      return (ImmutableNoteId) instance;
    }
    return ImmutableNoteId.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableNoteId ImmutableNoteId}.
   * @return A new ImmutableNoteId builder
   */
  public static ImmutableNoteId.Builder builder() {
    return new ImmutableNoteId.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableNoteId ImmutableNoteId}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String id;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NoteId} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(NoteId instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.id());
      return this;
    }

    /**
     * Initializes the value for the {@link NoteId#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("id")
    public final Builder id(String id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableNoteId ImmutableNoteId}.
     * @return An immutable instance of NoteId
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableNoteId build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableNoteId(id);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build NoteId, some of required attributes are not set " + attributes;
    }
  }
}
