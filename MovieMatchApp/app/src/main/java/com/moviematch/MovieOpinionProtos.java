// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: movie_opinion.proto

package com.moviematch;

public final class MovieOpinionProtos {
  private MovieOpinionProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MovieOpinionOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MovieOpinion)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 user_id = 1;</code>
     */
    long getUserId();

    /**
     * <code>string movie_name = 2;</code>
     */
    java.lang.String getMovieName();
    /**
     * <code>string movie_name = 2;</code>
     */
    com.google.protobuf.ByteString
        getMovieNameBytes();

    /**
     * <code>bool thumbs_up = 3;</code>
     */
    boolean getThumbsUp();
  }
  /**
   * <pre>
   * [START messages]
   * </pre>
   *
   * Protobuf type {@code MovieOpinion}
   */
  public  static final class MovieOpinion extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MovieOpinion)
      MovieOpinionOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MovieOpinion.newBuilder() to construct.
    private MovieOpinion(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MovieOpinion() {
      movieName_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MovieOpinion(
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
            case 8: {

              userId_ = input.readUInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              movieName_ = s;
              break;
            }
            case 24: {

              thumbsUp_ = input.readBool();
              break;
            }
            default: {
              if (!parseUnknownField(
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.moviematch.MovieOpinionProtos.internal_static_MovieOpinion_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.moviematch.MovieOpinionProtos.internal_static_MovieOpinion_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.moviematch.MovieOpinionProtos.MovieOpinion.class, com.moviematch.MovieOpinionProtos.MovieOpinion.Builder.class);
    }

    public static final int USER_ID_FIELD_NUMBER = 1;
    private long userId_;
    /**
     * <code>uint64 user_id = 1;</code>
     */
    public long getUserId() {
      return userId_;
    }

    public static final int MOVIE_NAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object movieName_;
    /**
     * <code>string movie_name = 2;</code>
     */
    public java.lang.String getMovieName() {
      java.lang.Object ref = movieName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        movieName_ = s;
        return s;
      }
    }
    /**
     * <code>string movie_name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMovieNameBytes() {
      java.lang.Object ref = movieName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        movieName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int THUMBS_UP_FIELD_NUMBER = 3;
    private boolean thumbsUp_;
    /**
     * <code>bool thumbs_up = 3;</code>
     */
    public boolean getThumbsUp() {
      return thumbsUp_;
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
      if (userId_ != 0L) {
        output.writeUInt64(1, userId_);
      }
      if (!getMovieNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, movieName_);
      }
      if (thumbsUp_ != false) {
        output.writeBool(3, thumbsUp_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (userId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, userId_);
      }
      if (!getMovieNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, movieName_);
      }
      if (thumbsUp_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, thumbsUp_);
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
      if (!(obj instanceof com.moviematch.MovieOpinionProtos.MovieOpinion)) {
        return super.equals(obj);
      }
      com.moviematch.MovieOpinionProtos.MovieOpinion other = (com.moviematch.MovieOpinionProtos.MovieOpinion) obj;

      if (getUserId()
          != other.getUserId()) return false;
      if (!getMovieName()
          .equals(other.getMovieName())) return false;
      if (getThumbsUp()
          != other.getThumbsUp()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + USER_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getUserId());
      hash = (37 * hash) + MOVIE_NAME_FIELD_NUMBER;
      hash = (53 * hash) + getMovieName().hashCode();
      hash = (37 * hash) + THUMBS_UP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getThumbsUp());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.moviematch.MovieOpinionProtos.MovieOpinion parseFrom(
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
    public static Builder newBuilder(com.moviematch.MovieOpinionProtos.MovieOpinion prototype) {
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
     * <pre>
     * [START messages]
     * </pre>
     *
     * Protobuf type {@code MovieOpinion}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MovieOpinion)
        com.moviematch.MovieOpinionProtos.MovieOpinionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.moviematch.MovieOpinionProtos.internal_static_MovieOpinion_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.moviematch.MovieOpinionProtos.internal_static_MovieOpinion_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.moviematch.MovieOpinionProtos.MovieOpinion.class, com.moviematch.MovieOpinionProtos.MovieOpinion.Builder.class);
      }

      // Construct using com.moviematch.MovieOpinionProtos.MovieOpinion.newBuilder()
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
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        userId_ = 0L;

        movieName_ = "";

        thumbsUp_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.moviematch.MovieOpinionProtos.internal_static_MovieOpinion_descriptor;
      }

      @java.lang.Override
      public com.moviematch.MovieOpinionProtos.MovieOpinion getDefaultInstanceForType() {
        return com.moviematch.MovieOpinionProtos.MovieOpinion.getDefaultInstance();
      }

      @java.lang.Override
      public com.moviematch.MovieOpinionProtos.MovieOpinion build() {
        com.moviematch.MovieOpinionProtos.MovieOpinion result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.moviematch.MovieOpinionProtos.MovieOpinion buildPartial() {
        com.moviematch.MovieOpinionProtos.MovieOpinion result = new com.moviematch.MovieOpinionProtos.MovieOpinion(this);
        result.userId_ = userId_;
        result.movieName_ = movieName_;
        result.thumbsUp_ = thumbsUp_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.moviematch.MovieOpinionProtos.MovieOpinion) {
          return mergeFrom((com.moviematch.MovieOpinionProtos.MovieOpinion)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.moviematch.MovieOpinionProtos.MovieOpinion other) {
        if (other == com.moviematch.MovieOpinionProtos.MovieOpinion.getDefaultInstance()) return this;
        if (other.getUserId() != 0L) {
          setUserId(other.getUserId());
        }
        if (!other.getMovieName().isEmpty()) {
          movieName_ = other.movieName_;
          onChanged();
        }
        if (other.getThumbsUp() != false) {
          setThumbsUp(other.getThumbsUp());
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
        com.moviematch.MovieOpinionProtos.MovieOpinion parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.moviematch.MovieOpinionProtos.MovieOpinion) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long userId_ ;
      /**
       * <code>uint64 user_id = 1;</code>
       */
      public long getUserId() {
        return userId_;
      }
      /**
       * <code>uint64 user_id = 1;</code>
       */
      public Builder setUserId(long value) {
        
        userId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint64 user_id = 1;</code>
       */
      public Builder clearUserId() {
        
        userId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object movieName_ = "";
      /**
       * <code>string movie_name = 2;</code>
       */
      public java.lang.String getMovieName() {
        java.lang.Object ref = movieName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          movieName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string movie_name = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMovieNameBytes() {
        java.lang.Object ref = movieName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          movieName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string movie_name = 2;</code>
       */
      public Builder setMovieName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        movieName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string movie_name = 2;</code>
       */
      public Builder clearMovieName() {
        
        movieName_ = getDefaultInstance().getMovieName();
        onChanged();
        return this;
      }
      /**
       * <code>string movie_name = 2;</code>
       */
      public Builder setMovieNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        movieName_ = value;
        onChanged();
        return this;
      }

      private boolean thumbsUp_ ;
      /**
       * <code>bool thumbs_up = 3;</code>
       */
      public boolean getThumbsUp() {
        return thumbsUp_;
      }
      /**
       * <code>bool thumbs_up = 3;</code>
       */
      public Builder setThumbsUp(boolean value) {
        
        thumbsUp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool thumbs_up = 3;</code>
       */
      public Builder clearThumbsUp() {
        
        thumbsUp_ = false;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:MovieOpinion)
    }

    // @@protoc_insertion_point(class_scope:MovieOpinion)
    private static final com.moviematch.MovieOpinionProtos.MovieOpinion DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.moviematch.MovieOpinionProtos.MovieOpinion();
    }

    public static com.moviematch.MovieOpinionProtos.MovieOpinion getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<MovieOpinion>
        PARSER = new com.google.protobuf.AbstractParser<MovieOpinion>() {
      @java.lang.Override
      public MovieOpinion parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MovieOpinion(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MovieOpinion> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MovieOpinion> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.moviematch.MovieOpinionProtos.MovieOpinion getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MovieOpinion_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MovieOpinion_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023movie_opinion.proto\"F\n\014MovieOpinion\022\017\n" +
      "\007user_id\030\001 \001(\004\022\022\n\nmovie_name\030\002 \001(\t\022\021\n\tth" +
      "umbs_up\030\003 \001(\010B$\n\016com.moviematchB\022MovieOp" +
      "inionProtosb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_MovieOpinion_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MovieOpinion_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MovieOpinion_descriptor,
        new java.lang.String[] { "UserId", "MovieName", "ThumbsUp", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}