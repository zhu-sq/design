package concurrent.FutureAndCallabe;

import sun.nio.ch.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        Future<Integer> future =new FutureTask<>(()->{
            Integer a=100;
            Integer b=1000;
            return a+b;
        });
        new Thread((FutureTask)future).start();

        System.out.println(future.get());

        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket soket = serverSocket.accept();

        }catch (IOException e){

        }

    }
}
