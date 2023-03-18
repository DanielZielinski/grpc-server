package daniel.zielinski.grpcserver.blockingstub;

import daniel.zielinski.grpc.HelloGrpc;
import daniel.zielinski.grpc.HelloReply;
import daniel.zielinski.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class GrpcServerService extends HelloGrpc.HelloImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        log.info("received request");
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
