// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PollutionSensor.proto

package PollutionSensor;

/**
 * Protobuf type {@code PollutionSensor.PollutionHistoryResponse}
 */
public  final class PollutionHistoryResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PollutionSensor.PollutionHistoryResponse)
    PollutionHistoryResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PollutionHistoryResponse.newBuilder() to construct.
  private PollutionHistoryResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PollutionHistoryResponse() {
    pollutionReadings_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PollutionHistoryResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              pollutionReadings_ = new java.util.ArrayList<PollutionSensor.PollutionReading>();
              mutable_bitField0_ |= 0x00000001;
            }
            pollutionReadings_.add(
                input.readMessage(PollutionSensor.PollutionReading.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        pollutionReadings_ = java.util.Collections.unmodifiableList(pollutionReadings_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return PollutionSensor.PollutionSensorImpl.internal_static_PollutionSensor_PollutionHistoryResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return PollutionSensor.PollutionSensorImpl.internal_static_PollutionSensor_PollutionHistoryResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            PollutionSensor.PollutionHistoryResponse.class, PollutionSensor.PollutionHistoryResponse.Builder.class);
  }

  public static final int POLLUTION_READINGS_FIELD_NUMBER = 1;
  private java.util.List<PollutionSensor.PollutionReading> pollutionReadings_;
  /**
   * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
   */
  public java.util.List<PollutionSensor.PollutionReading> getPollutionReadingsList() {
    return pollutionReadings_;
  }
  /**
   * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
   */
  public java.util.List<? extends PollutionSensor.PollutionReadingOrBuilder> 
      getPollutionReadingsOrBuilderList() {
    return pollutionReadings_;
  }
  /**
   * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
   */
  public int getPollutionReadingsCount() {
    return pollutionReadings_.size();
  }
  /**
   * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
   */
  public PollutionSensor.PollutionReading getPollutionReadings(int index) {
    return pollutionReadings_.get(index);
  }
  /**
   * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
   */
  public PollutionSensor.PollutionReadingOrBuilder getPollutionReadingsOrBuilder(
      int index) {
    return pollutionReadings_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < pollutionReadings_.size(); i++) {
      output.writeMessage(1, pollutionReadings_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < pollutionReadings_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, pollutionReadings_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof PollutionSensor.PollutionHistoryResponse)) {
      return super.equals(obj);
    }
    PollutionSensor.PollutionHistoryResponse other = (PollutionSensor.PollutionHistoryResponse) obj;

    boolean result = true;
    result = result && getPollutionReadingsList()
        .equals(other.getPollutionReadingsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getPollutionReadingsCount() > 0) {
      hash = (37 * hash) + POLLUTION_READINGS_FIELD_NUMBER;
      hash = (53 * hash) + getPollutionReadingsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static PollutionSensor.PollutionHistoryResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static PollutionSensor.PollutionHistoryResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static PollutionSensor.PollutionHistoryResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(PollutionSensor.PollutionHistoryResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code PollutionSensor.PollutionHistoryResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PollutionSensor.PollutionHistoryResponse)
      PollutionSensor.PollutionHistoryResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PollutionSensor.PollutionSensorImpl.internal_static_PollutionSensor_PollutionHistoryResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PollutionSensor.PollutionSensorImpl.internal_static_PollutionSensor_PollutionHistoryResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PollutionSensor.PollutionHistoryResponse.class, PollutionSensor.PollutionHistoryResponse.Builder.class);
    }

    // Construct using PollutionSensor.PollutionHistoryResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getPollutionReadingsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (pollutionReadingsBuilder_ == null) {
        pollutionReadings_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        pollutionReadingsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return PollutionSensor.PollutionSensorImpl.internal_static_PollutionSensor_PollutionHistoryResponse_descriptor;
    }

    @java.lang.Override
    public PollutionSensor.PollutionHistoryResponse getDefaultInstanceForType() {
      return PollutionSensor.PollutionHistoryResponse.getDefaultInstance();
    }

    @java.lang.Override
    public PollutionSensor.PollutionHistoryResponse build() {
      PollutionSensor.PollutionHistoryResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public PollutionSensor.PollutionHistoryResponse buildPartial() {
      PollutionSensor.PollutionHistoryResponse result = new PollutionSensor.PollutionHistoryResponse(this);
      int from_bitField0_ = bitField0_;
      if (pollutionReadingsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          pollutionReadings_ = java.util.Collections.unmodifiableList(pollutionReadings_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.pollutionReadings_ = pollutionReadings_;
      } else {
        result.pollutionReadings_ = pollutionReadingsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof PollutionSensor.PollutionHistoryResponse) {
        return mergeFrom((PollutionSensor.PollutionHistoryResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(PollutionSensor.PollutionHistoryResponse other) {
      if (other == PollutionSensor.PollutionHistoryResponse.getDefaultInstance()) return this;
      if (pollutionReadingsBuilder_ == null) {
        if (!other.pollutionReadings_.isEmpty()) {
          if (pollutionReadings_.isEmpty()) {
            pollutionReadings_ = other.pollutionReadings_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePollutionReadingsIsMutable();
            pollutionReadings_.addAll(other.pollutionReadings_);
          }
          onChanged();
        }
      } else {
        if (!other.pollutionReadings_.isEmpty()) {
          if (pollutionReadingsBuilder_.isEmpty()) {
            pollutionReadingsBuilder_.dispose();
            pollutionReadingsBuilder_ = null;
            pollutionReadings_ = other.pollutionReadings_;
            bitField0_ = (bitField0_ & ~0x00000001);
            pollutionReadingsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPollutionReadingsFieldBuilder() : null;
          } else {
            pollutionReadingsBuilder_.addAllMessages(other.pollutionReadings_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      PollutionSensor.PollutionHistoryResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (PollutionSensor.PollutionHistoryResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<PollutionSensor.PollutionReading> pollutionReadings_ =
      java.util.Collections.emptyList();
    private void ensurePollutionReadingsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        pollutionReadings_ = new java.util.ArrayList<PollutionSensor.PollutionReading>(pollutionReadings_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        PollutionSensor.PollutionReading, PollutionSensor.PollutionReading.Builder, PollutionSensor.PollutionReadingOrBuilder> pollutionReadingsBuilder_;

    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public java.util.List<PollutionSensor.PollutionReading> getPollutionReadingsList() {
      if (pollutionReadingsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(pollutionReadings_);
      } else {
        return pollutionReadingsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public int getPollutionReadingsCount() {
      if (pollutionReadingsBuilder_ == null) {
        return pollutionReadings_.size();
      } else {
        return pollutionReadingsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public PollutionSensor.PollutionReading getPollutionReadings(int index) {
      if (pollutionReadingsBuilder_ == null) {
        return pollutionReadings_.get(index);
      } else {
        return pollutionReadingsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder setPollutionReadings(
        int index, PollutionSensor.PollutionReading value) {
      if (pollutionReadingsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.set(index, value);
        onChanged();
      } else {
        pollutionReadingsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder setPollutionReadings(
        int index, PollutionSensor.PollutionReading.Builder builderForValue) {
      if (pollutionReadingsBuilder_ == null) {
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.set(index, builderForValue.build());
        onChanged();
      } else {
        pollutionReadingsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder addPollutionReadings(PollutionSensor.PollutionReading value) {
      if (pollutionReadingsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.add(value);
        onChanged();
      } else {
        pollutionReadingsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder addPollutionReadings(
        int index, PollutionSensor.PollutionReading value) {
      if (pollutionReadingsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.add(index, value);
        onChanged();
      } else {
        pollutionReadingsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder addPollutionReadings(
        PollutionSensor.PollutionReading.Builder builderForValue) {
      if (pollutionReadingsBuilder_ == null) {
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.add(builderForValue.build());
        onChanged();
      } else {
        pollutionReadingsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder addPollutionReadings(
        int index, PollutionSensor.PollutionReading.Builder builderForValue) {
      if (pollutionReadingsBuilder_ == null) {
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.add(index, builderForValue.build());
        onChanged();
      } else {
        pollutionReadingsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder addAllPollutionReadings(
        java.lang.Iterable<? extends PollutionSensor.PollutionReading> values) {
      if (pollutionReadingsBuilder_ == null) {
        ensurePollutionReadingsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, pollutionReadings_);
        onChanged();
      } else {
        pollutionReadingsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder clearPollutionReadings() {
      if (pollutionReadingsBuilder_ == null) {
        pollutionReadings_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        pollutionReadingsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public Builder removePollutionReadings(int index) {
      if (pollutionReadingsBuilder_ == null) {
        ensurePollutionReadingsIsMutable();
        pollutionReadings_.remove(index);
        onChanged();
      } else {
        pollutionReadingsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public PollutionSensor.PollutionReading.Builder getPollutionReadingsBuilder(
        int index) {
      return getPollutionReadingsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public PollutionSensor.PollutionReadingOrBuilder getPollutionReadingsOrBuilder(
        int index) {
      if (pollutionReadingsBuilder_ == null) {
        return pollutionReadings_.get(index);  } else {
        return pollutionReadingsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public java.util.List<? extends PollutionSensor.PollutionReadingOrBuilder> 
         getPollutionReadingsOrBuilderList() {
      if (pollutionReadingsBuilder_ != null) {
        return pollutionReadingsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(pollutionReadings_);
      }
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public PollutionSensor.PollutionReading.Builder addPollutionReadingsBuilder() {
      return getPollutionReadingsFieldBuilder().addBuilder(
          PollutionSensor.PollutionReading.getDefaultInstance());
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public PollutionSensor.PollutionReading.Builder addPollutionReadingsBuilder(
        int index) {
      return getPollutionReadingsFieldBuilder().addBuilder(
          index, PollutionSensor.PollutionReading.getDefaultInstance());
    }
    /**
     * <code>repeated .PollutionSensor.PollutionReading pollution_readings = 1;</code>
     */
    public java.util.List<PollutionSensor.PollutionReading.Builder> 
         getPollutionReadingsBuilderList() {
      return getPollutionReadingsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        PollutionSensor.PollutionReading, PollutionSensor.PollutionReading.Builder, PollutionSensor.PollutionReadingOrBuilder> 
        getPollutionReadingsFieldBuilder() {
      if (pollutionReadingsBuilder_ == null) {
        pollutionReadingsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            PollutionSensor.PollutionReading, PollutionSensor.PollutionReading.Builder, PollutionSensor.PollutionReadingOrBuilder>(
                pollutionReadings_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        pollutionReadings_ = null;
      }
      return pollutionReadingsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:PollutionSensor.PollutionHistoryResponse)
  }

  // @@protoc_insertion_point(class_scope:PollutionSensor.PollutionHistoryResponse)
  private static final PollutionSensor.PollutionHistoryResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PollutionSensor.PollutionHistoryResponse();
  }

  public static PollutionSensor.PollutionHistoryResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PollutionHistoryResponse>
      PARSER = new com.google.protobuf.AbstractParser<PollutionHistoryResponse>() {
    @java.lang.Override
    public PollutionHistoryResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PollutionHistoryResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PollutionHistoryResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PollutionHistoryResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public PollutionSensor.PollutionHistoryResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

