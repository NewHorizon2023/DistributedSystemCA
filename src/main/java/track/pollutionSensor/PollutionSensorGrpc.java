package track.pollutionSensor;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service 1: PollutionSensorService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PollutionSensor.proto")
public final class PollutionSensorGrpc {

  private PollutionSensorGrpc() {}

  public static final String SERVICE_NAME = "PollutionSensor.PollutionSensor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<track.pollutionSensor.PollutionLocation,
      track.pollutionSensor.PollutionReading> getGetPollutionLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPollutionLevel",
      requestType = track.pollutionSensor.PollutionLocation.class,
      responseType = track.pollutionSensor.PollutionReading.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<track.pollutionSensor.PollutionLocation,
      track.pollutionSensor.PollutionReading> getGetPollutionLevelMethod() {
    io.grpc.MethodDescriptor<track.pollutionSensor.PollutionLocation, track.pollutionSensor.PollutionReading> getGetPollutionLevelMethod;
    if ((getGetPollutionLevelMethod = PollutionSensorGrpc.getGetPollutionLevelMethod) == null) {
      synchronized (PollutionSensorGrpc.class) {
        if ((getGetPollutionLevelMethod = PollutionSensorGrpc.getGetPollutionLevelMethod) == null) {
          PollutionSensorGrpc.getGetPollutionLevelMethod = getGetPollutionLevelMethod = 
              io.grpc.MethodDescriptor.<track.pollutionSensor.PollutionLocation, track.pollutionSensor.PollutionReading>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PollutionSensor.PollutionSensor", "GetPollutionLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  track.pollutionSensor.PollutionLocation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  track.pollutionSensor.PollutionReading.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionSensorMethodDescriptorSupplier("GetPollutionLevel"))
                  .build();
          }
        }
     }
     return getGetPollutionLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<track.pollutionSensor.PollutionLocation,
      track.pollutionSensor.PollutionReading> getSubscribeToPollutionUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeToPollutionUpdates",
      requestType = track.pollutionSensor.PollutionLocation.class,
      responseType = track.pollutionSensor.PollutionReading.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<track.pollutionSensor.PollutionLocation,
      track.pollutionSensor.PollutionReading> getSubscribeToPollutionUpdatesMethod() {
    io.grpc.MethodDescriptor<track.pollutionSensor.PollutionLocation, track.pollutionSensor.PollutionReading> getSubscribeToPollutionUpdatesMethod;
    if ((getSubscribeToPollutionUpdatesMethod = PollutionSensorGrpc.getSubscribeToPollutionUpdatesMethod) == null) {
      synchronized (PollutionSensorGrpc.class) {
        if ((getSubscribeToPollutionUpdatesMethod = PollutionSensorGrpc.getSubscribeToPollutionUpdatesMethod) == null) {
          PollutionSensorGrpc.getSubscribeToPollutionUpdatesMethod = getSubscribeToPollutionUpdatesMethod = 
              io.grpc.MethodDescriptor.<track.pollutionSensor.PollutionLocation, track.pollutionSensor.PollutionReading>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PollutionSensor.PollutionSensor", "SubscribeToPollutionUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  track.pollutionSensor.PollutionLocation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  track.pollutionSensor.PollutionReading.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionSensorMethodDescriptorSupplier("SubscribeToPollutionUpdates"))
                  .build();
          }
        }
     }
     return getSubscribeToPollutionUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<track.pollutionSensor.PollutionHistoryRequest,
      track.pollutionSensor.PollutionHistoryResponse> getGetPollutionHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPollutionHistory",
      requestType = track.pollutionSensor.PollutionHistoryRequest.class,
      responseType = track.pollutionSensor.PollutionHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<track.pollutionSensor.PollutionHistoryRequest,
      track.pollutionSensor.PollutionHistoryResponse> getGetPollutionHistoryMethod() {
    io.grpc.MethodDescriptor<track.pollutionSensor.PollutionHistoryRequest, track.pollutionSensor.PollutionHistoryResponse> getGetPollutionHistoryMethod;
    if ((getGetPollutionHistoryMethod = PollutionSensorGrpc.getGetPollutionHistoryMethod) == null) {
      synchronized (PollutionSensorGrpc.class) {
        if ((getGetPollutionHistoryMethod = PollutionSensorGrpc.getGetPollutionHistoryMethod) == null) {
          PollutionSensorGrpc.getGetPollutionHistoryMethod = getGetPollutionHistoryMethod = 
              io.grpc.MethodDescriptor.<track.pollutionSensor.PollutionHistoryRequest, track.pollutionSensor.PollutionHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PollutionSensor.PollutionSensor", "GetPollutionHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  track.pollutionSensor.PollutionHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  track.pollutionSensor.PollutionHistoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionSensorMethodDescriptorSupplier("GetPollutionHistory"))
                  .build();
          }
        }
     }
     return getGetPollutionHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PollutionSensorStub newStub(io.grpc.Channel channel) {
    return new PollutionSensorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PollutionSensorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PollutionSensorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PollutionSensorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PollutionSensorFutureStub(channel);
  }

  /**
   * <pre>
   * Service 1: PollutionSensorService
   * </pre>
   */
  public static abstract class PollutionSensorImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC Method 1: GetPollutionLevel
     * </pre>
     */
    public void getPollutionLevel(track.pollutionSensor.PollutionLocation request,
        io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPollutionLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC Method 2: SubscribeToPollutionUpdates
     * </pre>
     */
    public void subscribeToPollutionUpdates(track.pollutionSensor.PollutionLocation request,
        io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeToPollutionUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC Method 3: GetPollutionHistory
     * </pre>
     */
    public void getPollutionHistory(track.pollutionSensor.PollutionHistoryRequest request,
        io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionHistoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPollutionHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPollutionLevelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                track.pollutionSensor.PollutionLocation,
                track.pollutionSensor.PollutionReading>(
                  this, METHODID_GET_POLLUTION_LEVEL)))
          .addMethod(
            getSubscribeToPollutionUpdatesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                track.pollutionSensor.PollutionLocation,
                track.pollutionSensor.PollutionReading>(
                  this, METHODID_SUBSCRIBE_TO_POLLUTION_UPDATES)))
          .addMethod(
            getGetPollutionHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                track.pollutionSensor.PollutionHistoryRequest,
                track.pollutionSensor.PollutionHistoryResponse>(
                  this, METHODID_GET_POLLUTION_HISTORY)))
          .build();
    }
  }

  /**
   * <pre>
   * Service 1: PollutionSensorService
   * </pre>
   */
  public static final class PollutionSensorStub extends io.grpc.stub.AbstractStub<PollutionSensorStub> {
    private PollutionSensorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionSensorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionSensorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionSensorStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC Method 1: GetPollutionLevel
     * </pre>
     */
    public void getPollutionLevel(track.pollutionSensor.PollutionLocation request,
        io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPollutionLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC Method 2: SubscribeToPollutionUpdates
     * </pre>
     */
    public void subscribeToPollutionUpdates(track.pollutionSensor.PollutionLocation request,
        io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeToPollutionUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC Method 3: GetPollutionHistory
     * </pre>
     */
    public void getPollutionHistory(track.pollutionSensor.PollutionHistoryRequest request,
        io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionHistoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPollutionHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service 1: PollutionSensorService
   * </pre>
   */
  public static final class PollutionSensorBlockingStub extends io.grpc.stub.AbstractStub<PollutionSensorBlockingStub> {
    private PollutionSensorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionSensorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionSensorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionSensorBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC Method 1: GetPollutionLevel
     * </pre>
     */
    public track.pollutionSensor.PollutionReading getPollutionLevel(track.pollutionSensor.PollutionLocation request) {
      return blockingUnaryCall(
          getChannel(), getGetPollutionLevelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC Method 2: SubscribeToPollutionUpdates
     * </pre>
     */
    public java.util.Iterator<track.pollutionSensor.PollutionReading> subscribeToPollutionUpdates(
        track.pollutionSensor.PollutionLocation request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeToPollutionUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC Method 3: GetPollutionHistory
     * </pre>
     */
    public track.pollutionSensor.PollutionHistoryResponse getPollutionHistory(track.pollutionSensor.PollutionHistoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPollutionHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service 1: PollutionSensorService
   * </pre>
   */
  public static final class PollutionSensorFutureStub extends io.grpc.stub.AbstractStub<PollutionSensorFutureStub> {
    private PollutionSensorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionSensorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionSensorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionSensorFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC Method 1: GetPollutionLevel
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<track.pollutionSensor.PollutionReading> getPollutionLevel(
        track.pollutionSensor.PollutionLocation request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPollutionLevelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC Method 3: GetPollutionHistory
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<track.pollutionSensor.PollutionHistoryResponse> getPollutionHistory(
        track.pollutionSensor.PollutionHistoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPollutionHistoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POLLUTION_LEVEL = 0;
  private static final int METHODID_SUBSCRIBE_TO_POLLUTION_UPDATES = 1;
  private static final int METHODID_GET_POLLUTION_HISTORY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PollutionSensorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PollutionSensorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POLLUTION_LEVEL:
          serviceImpl.getPollutionLevel((track.pollutionSensor.PollutionLocation) request,
              (io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_TO_POLLUTION_UPDATES:
          serviceImpl.subscribeToPollutionUpdates((track.pollutionSensor.PollutionLocation) request,
              (io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading>) responseObserver);
          break;
        case METHODID_GET_POLLUTION_HISTORY:
          serviceImpl.getPollutionHistory((track.pollutionSensor.PollutionHistoryRequest) request,
              (io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionHistoryResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PollutionSensorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PollutionSensorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return track.pollutionSensor.PollutionSensorImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PollutionSensor");
    }
  }

  private static final class PollutionSensorFileDescriptorSupplier
      extends PollutionSensorBaseDescriptorSupplier {
    PollutionSensorFileDescriptorSupplier() {}
  }

  private static final class PollutionSensorMethodDescriptorSupplier
      extends PollutionSensorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PollutionSensorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PollutionSensorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PollutionSensorFileDescriptorSupplier())
              .addMethod(getGetPollutionLevelMethod())
              .addMethod(getSubscribeToPollutionUpdatesMethod())
              .addMethod(getGetPollutionHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
