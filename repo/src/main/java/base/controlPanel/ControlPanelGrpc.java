package base.controlPanel;

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
 * <pre>
 * Service 3: ControlPanelService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ControlPanel.proto")
public final class ControlPanelGrpc {

  private ControlPanelGrpc() {}

  public static final String SERVICE_NAME = "ControlPanel.ControlPanel";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<base.controlPanel.DeviceStatusRequest,
      base.controlPanel.DeviceStatusResponse> getSetDeviceStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetDeviceStatus",
      requestType = base.controlPanel.DeviceStatusRequest.class,
      responseType = base.controlPanel.DeviceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<base.controlPanel.DeviceStatusRequest,
      base.controlPanel.DeviceStatusResponse> getSetDeviceStatusMethod() {
    io.grpc.MethodDescriptor<base.controlPanel.DeviceStatusRequest, base.controlPanel.DeviceStatusResponse> getSetDeviceStatusMethod;
    if ((getSetDeviceStatusMethod = ControlPanelGrpc.getSetDeviceStatusMethod) == null) {
      synchronized (ControlPanelGrpc.class) {
        if ((getSetDeviceStatusMethod = ControlPanelGrpc.getSetDeviceStatusMethod) == null) {
          ControlPanelGrpc.getSetDeviceStatusMethod = getSetDeviceStatusMethod = 
              io.grpc.MethodDescriptor.<base.controlPanel.DeviceStatusRequest, base.controlPanel.DeviceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ControlPanel.ControlPanel", "SetDeviceStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.controlPanel.DeviceStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.controlPanel.DeviceStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ControlPanelMethodDescriptorSupplier("SetDeviceStatus"))
                  .build();
          }
        }
     }
     return getSetDeviceStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<base.controlPanel.DeviceIdentifier,
      base.controlPanel.DeviceStatusResponse> getGetDeviceStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceStatus",
      requestType = base.controlPanel.DeviceIdentifier.class,
      responseType = base.controlPanel.DeviceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<base.controlPanel.DeviceIdentifier,
      base.controlPanel.DeviceStatusResponse> getGetDeviceStatusMethod() {
    io.grpc.MethodDescriptor<base.controlPanel.DeviceIdentifier, base.controlPanel.DeviceStatusResponse> getGetDeviceStatusMethod;
    if ((getGetDeviceStatusMethod = ControlPanelGrpc.getGetDeviceStatusMethod) == null) {
      synchronized (ControlPanelGrpc.class) {
        if ((getGetDeviceStatusMethod = ControlPanelGrpc.getGetDeviceStatusMethod) == null) {
          ControlPanelGrpc.getGetDeviceStatusMethod = getGetDeviceStatusMethod = 
              io.grpc.MethodDescriptor.<base.controlPanel.DeviceIdentifier, base.controlPanel.DeviceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ControlPanel.ControlPanel", "GetDeviceStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.controlPanel.DeviceIdentifier.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.controlPanel.DeviceStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ControlPanelMethodDescriptorSupplier("GetDeviceStatus"))
                  .build();
          }
        }
     }
     return getGetDeviceStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<base.controlPanel.DeviceIdentifier,
      base.controlPanel.DeviceLog> getStreamDeviceLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamDeviceLogs",
      requestType = base.controlPanel.DeviceIdentifier.class,
      responseType = base.controlPanel.DeviceLog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<base.controlPanel.DeviceIdentifier,
      base.controlPanel.DeviceLog> getStreamDeviceLogsMethod() {
    io.grpc.MethodDescriptor<base.controlPanel.DeviceIdentifier, base.controlPanel.DeviceLog> getStreamDeviceLogsMethod;
    if ((getStreamDeviceLogsMethod = ControlPanelGrpc.getStreamDeviceLogsMethod) == null) {
      synchronized (ControlPanelGrpc.class) {
        if ((getStreamDeviceLogsMethod = ControlPanelGrpc.getStreamDeviceLogsMethod) == null) {
          ControlPanelGrpc.getStreamDeviceLogsMethod = getStreamDeviceLogsMethod = 
              io.grpc.MethodDescriptor.<base.controlPanel.DeviceIdentifier, base.controlPanel.DeviceLog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ControlPanel.ControlPanel", "StreamDeviceLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.controlPanel.DeviceIdentifier.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.controlPanel.DeviceLog.getDefaultInstance()))
                  .setSchemaDescriptor(new ControlPanelMethodDescriptorSupplier("StreamDeviceLogs"))
                  .build();
          }
        }
     }
     return getStreamDeviceLogsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControlPanelStub newStub(io.grpc.Channel channel) {
    return new ControlPanelStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControlPanelBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ControlPanelBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControlPanelFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ControlPanelFutureStub(channel);
  }

  /**
   * <pre>
   * Service 3: ControlPanelService
   * </pre>
   */
  public static abstract class ControlPanelImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC Method: SetDeviceStatus
     * </pre>
     */
    public void setDeviceStatus(base.controlPanel.DeviceStatusRequest request,
        io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetDeviceStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client Streaming RPC Method: GetDeviceStatus
     * </pre>
     */
    public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> getDeviceStatus(
        io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetDeviceStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional Streaming RPC Method: StreamDeviceLogs
     * </pre>
     */
    public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> streamDeviceLogs(
        io.grpc.stub.StreamObserver<base.controlPanel.DeviceLog> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamDeviceLogsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetDeviceStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                base.controlPanel.DeviceStatusRequest,
                base.controlPanel.DeviceStatusResponse>(
                  this, METHODID_SET_DEVICE_STATUS)))
          .addMethod(
            getGetDeviceStatusMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                base.controlPanel.DeviceIdentifier,
                base.controlPanel.DeviceStatusResponse>(
                  this, METHODID_GET_DEVICE_STATUS)))
          .addMethod(
            getStreamDeviceLogsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                base.controlPanel.DeviceIdentifier,
                base.controlPanel.DeviceLog>(
                  this, METHODID_STREAM_DEVICE_LOGS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service 3: ControlPanelService
   * </pre>
   */
  public static final class ControlPanelStub extends io.grpc.stub.AbstractStub<ControlPanelStub> {
    private ControlPanelStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControlPanelStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlPanelStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControlPanelStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC Method: SetDeviceStatus
     * </pre>
     */
    public void setDeviceStatus(base.controlPanel.DeviceStatusRequest request,
        io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetDeviceStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client Streaming RPC Method: GetDeviceStatus
     * </pre>
     */
    public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> getDeviceStatus(
        io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetDeviceStatusMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional Streaming RPC Method: StreamDeviceLogs
     * </pre>
     */
    public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> streamDeviceLogs(
        io.grpc.stub.StreamObserver<base.controlPanel.DeviceLog> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamDeviceLogsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service 3: ControlPanelService
   * </pre>
   */
  public static final class ControlPanelBlockingStub extends io.grpc.stub.AbstractStub<ControlPanelBlockingStub> {
    private ControlPanelBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControlPanelBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlPanelBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControlPanelBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC Method: SetDeviceStatus
     * </pre>
     */
    public base.controlPanel.DeviceStatusResponse setDeviceStatus(base.controlPanel.DeviceStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetDeviceStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service 3: ControlPanelService
   * </pre>
   */
  public static final class ControlPanelFutureStub extends io.grpc.stub.AbstractStub<ControlPanelFutureStub> {
    private ControlPanelFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControlPanelFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlPanelFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControlPanelFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC Method: SetDeviceStatus
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<base.controlPanel.DeviceStatusResponse> setDeviceStatus(
        base.controlPanel.DeviceStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetDeviceStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_DEVICE_STATUS = 0;
  private static final int METHODID_GET_DEVICE_STATUS = 1;
  private static final int METHODID_STREAM_DEVICE_LOGS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControlPanelImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControlPanelImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_DEVICE_STATUS:
          serviceImpl.setDeviceStatus((base.controlPanel.DeviceStatusRequest) request,
              (io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse>) responseObserver);
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
        case METHODID_GET_DEVICE_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getDeviceStatus(
              (io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse>) responseObserver);
        case METHODID_STREAM_DEVICE_LOGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamDeviceLogs(
              (io.grpc.stub.StreamObserver<base.controlPanel.DeviceLog>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ControlPanelBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlPanelBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return base.controlPanel.ControlPanelImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ControlPanel");
    }
  }

  private static final class ControlPanelFileDescriptorSupplier
      extends ControlPanelBaseDescriptorSupplier {
    ControlPanelFileDescriptorSupplier() {}
  }

  private static final class ControlPanelMethodDescriptorSupplier
      extends ControlPanelBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControlPanelMethodDescriptorSupplier(String methodName) {
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
      synchronized (ControlPanelGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControlPanelFileDescriptorSupplier())
              .addMethod(getSetDeviceStatusMethod())
              .addMethod(getGetDeviceStatusMethod())
              .addMethod(getStreamDeviceLogsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
