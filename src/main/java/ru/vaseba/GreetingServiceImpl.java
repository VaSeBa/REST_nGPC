package ru.vaseba;

import io.grpc.stub.StreamObserver;
import ru.vaseba.grpc.GreetingServiceGrpc;
import ru.vaseba.grpc.GreetingServiceOuterClass;

/**
 * GreetingServiceGrpc содержит класс GreetingServiceImplBase - в нем находится метод Greeting
 * который необходимо переопределить.
 */
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    //переопределение методов из proto файла HelloRequest, HelloResponse
    //HelloRequest, HelloResponse - ответ при этом не возвращается из второго метода т.к. gRPC позволяет давать ответ не одним сообщением а целым списком
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {

        System.out.println(request);

        //применяется паттерн Builder для конструирования ответа клиенту
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass
                .HelloResponse.newBuilder().setGreeting("Hello from server, " + request.getName())
                .build();
        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }

}
