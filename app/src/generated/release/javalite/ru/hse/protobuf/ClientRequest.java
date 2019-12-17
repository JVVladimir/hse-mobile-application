// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: export.proto

package ru.hse.protobuf;

/**
 * Protobuf type {@code ru.hse.protobuf.ClientRequest}
 */
public  final class ClientRequest extends
    com.google.protobuf.GeneratedMessageLite<
        ClientRequest, ClientRequest.Builder> implements
    // @@protoc_insertion_point(message_implements:ru.hse.protobuf.ClientRequest)
    ClientRequestOrBuilder {
  private ClientRequest() {
    id_ = "";
    mark_ = "";
    description_ = "";
  }
  public static final int ID_FIELD_NUMBER = 1;
  private java.lang.String id_;
  /**
   * <code>optional string id = 1;</code>
   */
  public java.lang.String getId() {
    return id_;
  }
  /**
   * <code>optional string id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(id_);
  }
  /**
   * <code>optional string id = 1;</code>
   */
  private void setId(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    id_ = value;
  }
  /**
   * <code>optional string id = 1;</code>
   */
  private void clearId() {
    
    id_ = getDefaultInstance().getId();
  }
  /**
   * <code>optional string id = 1;</code>
   */
  private void setIdBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    id_ = value.toStringUtf8();
  }

  public static final int MARK_FIELD_NUMBER = 2;
  private java.lang.String mark_;
  /**
   * <code>optional string mark = 2;</code>
   */
  public java.lang.String getMark() {
    return mark_;
  }
  /**
   * <code>optional string mark = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMarkBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(mark_);
  }
  /**
   * <code>optional string mark = 2;</code>
   */
  private void setMark(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    mark_ = value;
  }
  /**
   * <code>optional string mark = 2;</code>
   */
  private void clearMark() {
    
    mark_ = getDefaultInstance().getMark();
  }
  /**
   * <code>optional string mark = 2;</code>
   */
  private void setMarkBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    mark_ = value.toStringUtf8();
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  private java.lang.String description_;
  /**
   * <code>optional string description = 3;</code>
   */
  public java.lang.String getDescription() {
    return description_;
  }
  /**
   * <code>optional string description = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(description_);
  }
  /**
   * <code>optional string description = 3;</code>
   */
  private void setDescription(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    description_ = value;
  }
  /**
   * <code>optional string description = 3;</code>
   */
  private void clearDescription() {
    
    description_ = getDefaultInstance().getDescription();
  }
  /**
   * <code>optional string description = 3;</code>
   */
  private void setDescriptionBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    description_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!id_.isEmpty()) {
      output.writeString(1, getId());
    }
    if (!mark_.isEmpty()) {
      output.writeString(2, getMark());
    }
    if (!description_.isEmpty()) {
      output.writeString(3, getDescription());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!id_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getId());
    }
    if (!mark_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getMark());
    }
    if (!description_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getDescription());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ru.hse.protobuf.ClientRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ru.hse.protobuf.ClientRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ru.hse.protobuf.ClientRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ru.hse.protobuf.ClientRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.hse.protobuf.ClientRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code ru.hse.protobuf.ClientRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ru.hse.protobuf.ClientRequest, Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.hse.protobuf.ClientRequest)
      ru.hse.protobuf.ClientRequestOrBuilder {
    // Construct using ru.hse.protobuf.ClientRequest.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>optional string id = 1;</code>
     */
    public java.lang.String getId() {
      return instance.getId();
    }
    /**
     * <code>optional string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      return instance.getIdBytes();
    }
    /**
     * <code>optional string id = 1;</code>
     */
    public Builder setId(
        java.lang.String value) {
      copyOnWrite();
      instance.setId(value);
      return this;
    }
    /**
     * <code>optional string id = 1;</code>
     */
    public Builder clearId() {
      copyOnWrite();
      instance.clearId();
      return this;
    }
    /**
     * <code>optional string id = 1;</code>
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setIdBytes(value);
      return this;
    }

    /**
     * <code>optional string mark = 2;</code>
     */
    public java.lang.String getMark() {
      return instance.getMark();
    }
    /**
     * <code>optional string mark = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMarkBytes() {
      return instance.getMarkBytes();
    }
    /**
     * <code>optional string mark = 2;</code>
     */
    public Builder setMark(
        java.lang.String value) {
      copyOnWrite();
      instance.setMark(value);
      return this;
    }
    /**
     * <code>optional string mark = 2;</code>
     */
    public Builder clearMark() {
      copyOnWrite();
      instance.clearMark();
      return this;
    }
    /**
     * <code>optional string mark = 2;</code>
     */
    public Builder setMarkBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMarkBytes(value);
      return this;
    }

    /**
     * <code>optional string description = 3;</code>
     */
    public java.lang.String getDescription() {
      return instance.getDescription();
    }
    /**
     * <code>optional string description = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      return instance.getDescriptionBytes();
    }
    /**
     * <code>optional string description = 3;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      copyOnWrite();
      instance.setDescription(value);
      return this;
    }
    /**
     * <code>optional string description = 3;</code>
     */
    public Builder clearDescription() {
      copyOnWrite();
      instance.clearDescription();
      return this;
    }
    /**
     * <code>optional string description = 3;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setDescriptionBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:ru.hse.protobuf.ClientRequest)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ru.hse.protobuf.ClientRequest();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ru.hse.protobuf.ClientRequest other = (ru.hse.protobuf.ClientRequest) arg1;
        id_ = visitor.visitString(!id_.isEmpty(), id_,
            !other.id_.isEmpty(), other.id_);
        mark_ = visitor.visitString(!mark_.isEmpty(), mark_,
            !other.mark_.isEmpty(), other.mark_);
        description_ = visitor.visitString(!description_.isEmpty(), description_,
            !other.description_.isEmpty(), other.description_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
              case 10: {
                String s = input.readStringRequireUtf8();

                id_ = s;
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                mark_ = s;
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                description_ = s;
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (ru.hse.protobuf.ClientRequest.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:ru.hse.protobuf.ClientRequest)
  private static final ru.hse.protobuf.ClientRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ClientRequest();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ru.hse.protobuf.ClientRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<ClientRequest> PARSER;

  public static com.google.protobuf.Parser<ClientRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

