package ru.hse.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: export.proto")
public final class HandlerServiceGrpc {

  private HandlerServiceGrpc() {}

  public static final String SERVICE_NAME = "ru.hse.protobuf.HandlerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.hse.protobuf.ClientRequest,
      ru.hse.protobuf.ServerResponse> getHandleRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "handleRequest",
      requestType = ru.hse.protobuf.ClientRequest.class,
      responseType = ru.hse.protobuf.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ru.hse.protobuf.ClientRequest,
      ru.hse.protobuf.ServerResponse> getHandleRequestMethod() {
    io.grpc.MethodDescriptor<ru.hse.protobuf.ClientRequest, ru.hse.protobuf.ServerResponse> getHandleRequestMethod;
    if ((getHandleRequestMethod = HandlerServiceGrpc.getHandleRequestMethod) == null) {
      synchronized (HandlerServiceGrpc.class) {
        if ((getHandleRequestMethod = HandlerServiceGrpc.getHandleRequestMethod) == null) {
          HandlerServiceGrpc.getHandleRequestMethod = getHandleRequestMethod =
              io.grpc.MethodDescriptor.<ru.hse.protobuf.ClientRequest, ru.hse.protobuf.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "handleRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ru.hse.protobuf.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ru.hse.protobuf.ServerResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getHandleRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HandlerServiceStub newStub(io.grpc.Channel channel) {
    return new HandlerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HandlerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HandlerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HandlerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HandlerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HandlerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ru.hse.protobuf.ClientRequest> handleRequest(
        io.grpc.stub.StreamObserver<ru.hse.protobuf.ServerResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getHandleRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandleRequestMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ru.hse.protobuf.ClientRequest,
                ru.hse.protobuf.ServerResponse>(
                  this, METHODID_HANDLE_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class HandlerServiceStub extends io.grpc.stub.AbstractStub<HandlerServiceStub> {
    private HandlerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HandlerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HandlerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HandlerServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ru.hse.protobuf.ClientRequest> handleRequest(
        io.grpc.stub.StreamObserver<ru.hse.protobuf.ServerResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getHandleRequestMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HandlerServiceBlockingStub extends io.grpc.stub.AbstractStub<HandlerServiceBlockingStub> {
    private HandlerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HandlerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HandlerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HandlerServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HandlerServiceFutureStub extends io.grpc.stub.AbstractStub<HandlerServiceFutureStub> {
    private HandlerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HandlerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HandlerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HandlerServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HANDLE_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HandlerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HandlerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDLE_REQUEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.handleRequest(
              (io.grpc.stub.StreamObserver<ru.hse.protobuf.ServerResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HandlerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getHandleRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
