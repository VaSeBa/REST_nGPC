package ru.vaseba;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println( "Server started" );

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
