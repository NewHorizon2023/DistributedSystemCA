package base.weather;

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
 * Service 2: WeatherService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Weather.proto")
public final class WeatherGrpc {

  private WeatherGrpc() {}

  public static final String SERVICE_NAME = "Weather.Weather";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<base.weather.WeatherLocation,
      base.weather.TemperatureResponse> getGetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemperature",
      requestType = base.weather.WeatherLocation.class,
      responseType = base.weather.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<base.weather.WeatherLocation,
      base.weather.TemperatureResponse> getGetTemperatureMethod() {
    io.grpc.MethodDescriptor<base.weather.WeatherLocation, base.weather.TemperatureResponse> getGetTemperatureMethod;
    if ((getGetTemperatureMethod = WeatherGrpc.getGetTemperatureMethod) == null) {
      synchronized (WeatherGrpc.class) {
        if ((getGetTemperatureMethod = WeatherGrpc.getGetTemperatureMethod) == null) {
          WeatherGrpc.getGetTemperatureMethod = getGetTemperatureMethod = 
              io.grpc.MethodDescriptor.<base.weather.WeatherLocation, base.weather.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Weather.Weather", "GetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.weather.WeatherLocation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.weather.TemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WeatherMethodDescriptorSupplier("GetTemperature"))
                  .build();
          }
        }
     }
     return getGetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<base.weather.WeatherLocation,
      base.weather.HumidityResponse> getGetHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHumidity",
      requestType = base.weather.WeatherLocation.class,
      responseType = base.weather.HumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<base.weather.WeatherLocation,
      base.weather.HumidityResponse> getGetHumidityMethod() {
    io.grpc.MethodDescriptor<base.weather.WeatherLocation, base.weather.HumidityResponse> getGetHumidityMethod;
    if ((getGetHumidityMethod = WeatherGrpc.getGetHumidityMethod) == null) {
      synchronized (WeatherGrpc.class) {
        if ((getGetHumidityMethod = WeatherGrpc.getGetHumidityMethod) == null) {
          WeatherGrpc.getGetHumidityMethod = getGetHumidityMethod = 
              io.grpc.MethodDescriptor.<base.weather.WeatherLocation, base.weather.HumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Weather.Weather", "GetHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.weather.WeatherLocation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.weather.HumidityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WeatherMethodDescriptorSupplier("GetHumidity"))
                  .build();
          }
        }
     }
     return getGetHumidityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<base.weather.WeatherForecastRequest,
      base.weather.WeatherForecastResponse> getGetWeatherForecastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherForecast",
      requestType = base.weather.WeatherForecastRequest.class,
      responseType = base.weather.WeatherForecastResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<base.weather.WeatherForecastRequest,
      base.weather.WeatherForecastResponse> getGetWeatherForecastMethod() {
    io.grpc.MethodDescriptor<base.weather.WeatherForecastRequest, base.weather.WeatherForecastResponse> getGetWeatherForecastMethod;
    if ((getGetWeatherForecastMethod = WeatherGrpc.getGetWeatherForecastMethod) == null) {
      synchronized (WeatherGrpc.class) {
        if ((getGetWeatherForecastMethod = WeatherGrpc.getGetWeatherForecastMethod) == null) {
          WeatherGrpc.getGetWeatherForecastMethod = getGetWeatherForecastMethod = 
              io.grpc.MethodDescriptor.<base.weather.WeatherForecastRequest, base.weather.WeatherForecastResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Weather.Weather", "GetWeatherForecast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.weather.WeatherForecastRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  base.weather.WeatherForecastResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WeatherMethodDescriptorSupplier("GetWeatherForecast"))
                  .build();
          }
        }
     }
     return getGetWeatherForecastMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherStub newStub(io.grpc.Channel channel) {
    return new WeatherStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WeatherBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WeatherFutureStub(channel);
  }

  /**
   * <pre>
   * Service 2: WeatherService
   * </pre>
   */
  public static abstract class WeatherImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC Method 1: GetTemperature
     * </pre>
     */
    public void getTemperature(base.weather.WeatherLocation request,
        io.grpc.stub.StreamObserver<base.weather.TemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC Method 2: GetHumidity
     * </pre>
     */
    public void getHumidity(base.weather.WeatherLocation request,
        io.grpc.stub.StreamObserver<base.weather.HumidityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetHumidityMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC Method 3: GetWeatherForecast
     * </pre>
     */
    public void getWeatherForecast(base.weather.WeatherForecastRequest request,
        io.grpc.stub.StreamObserver<base.weather.WeatherForecastResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetWeatherForecastMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                base.weather.WeatherLocation,
                base.weather.TemperatureResponse>(
                  this, METHODID_GET_TEMPERATURE)))
          .addMethod(
            getGetHumidityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                base.weather.WeatherLocation,
                base.weather.HumidityResponse>(
                  this, METHODID_GET_HUMIDITY)))
          .addMethod(
            getGetWeatherForecastMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                base.weather.WeatherForecastRequest,
                base.weather.WeatherForecastResponse>(
                  this, METHODID_GET_WEATHER_FORECAST)))
          .build();
    }
  }

  /**
   * <pre>
   * Service 2: WeatherService
   * </pre>
   */
  public static final class WeatherStub extends io.grpc.stub.AbstractStub<WeatherStub> {
    private WeatherStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC Method 1: GetTemperature
     * </pre>
     */
    public void getTemperature(base.weather.WeatherLocation request,
        io.grpc.stub.StreamObserver<base.weather.TemperatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC Method 2: GetHumidity
     * </pre>
     */
    public void getHumidity(base.weather.WeatherLocation request,
        io.grpc.stub.StreamObserver<base.weather.HumidityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetHumidityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC Method 3: GetWeatherForecast
     * </pre>
     */
    public void getWeatherForecast(base.weather.WeatherForecastRequest request,
        io.grpc.stub.StreamObserver<base.weather.WeatherForecastResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWeatherForecastMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service 2: WeatherService
   * </pre>
   */
  public static final class WeatherBlockingStub extends io.grpc.stub.AbstractStub<WeatherBlockingStub> {
    private WeatherBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC Method 1: GetTemperature
     * </pre>
     */
    public base.weather.TemperatureResponse getTemperature(base.weather.WeatherLocation request) {
      return blockingUnaryCall(
          getChannel(), getGetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC Method 2: GetHumidity
     * </pre>
     */
    public base.weather.HumidityResponse getHumidity(base.weather.WeatherLocation request) {
      return blockingUnaryCall(
          getChannel(), getGetHumidityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC Method 3: GetWeatherForecast
     * </pre>
     */
    public base.weather.WeatherForecastResponse getWeatherForecast(base.weather.WeatherForecastRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWeatherForecastMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service 2: WeatherService
   * </pre>
   */
  public static final class WeatherFutureStub extends io.grpc.stub.AbstractStub<WeatherFutureStub> {
    private WeatherFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC Method 1: GetTemperature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<base.weather.TemperatureResponse> getTemperature(
        base.weather.WeatherLocation request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC Method 2: GetHumidity
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<base.weather.HumidityResponse> getHumidity(
        base.weather.WeatherLocation request) {
      return futureUnaryCall(
          getChannel().newCall(getGetHumidityMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC Method 3: GetWeatherForecast
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<base.weather.WeatherForecastResponse> getWeatherForecast(
        base.weather.WeatherForecastRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWeatherForecastMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TEMPERATURE = 0;
  private static final int METHODID_GET_HUMIDITY = 1;
  private static final int METHODID_GET_WEATHER_FORECAST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WeatherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WeatherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TEMPERATURE:
          serviceImpl.getTemperature((base.weather.WeatherLocation) request,
              (io.grpc.stub.StreamObserver<base.weather.TemperatureResponse>) responseObserver);
          break;
        case METHODID_GET_HUMIDITY:
          serviceImpl.getHumidity((base.weather.WeatherLocation) request,
              (io.grpc.stub.StreamObserver<base.weather.HumidityResponse>) responseObserver);
          break;
        case METHODID_GET_WEATHER_FORECAST:
          serviceImpl.getWeatherForecast((base.weather.WeatherForecastRequest) request,
              (io.grpc.stub.StreamObserver<base.weather.WeatherForecastResponse>) responseObserver);
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

  private static abstract class WeatherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return base.weather.WeatherImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Weather");
    }
  }

  private static final class WeatherFileDescriptorSupplier
      extends WeatherBaseDescriptorSupplier {
    WeatherFileDescriptorSupplier() {}
  }

  private static final class WeatherMethodDescriptorSupplier
      extends WeatherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WeatherMethodDescriptorSupplier(String methodName) {
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
      synchronized (WeatherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherFileDescriptorSupplier())
              .addMethod(getGetTemperatureMethod())
              .addMethod(getGetHumidityMethod())
              .addMethod(getGetWeatherForecastMethod())
              .build();
        }
      }
    }
    return result;
  }
}
