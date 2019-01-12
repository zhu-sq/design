package concurrent.FutureAndCallabe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        Future<String> future =new FutureTask<>(()->{
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "123456";
        });

        new Thread((FutureTask<String>)future).start();

        System.out.println(future.get());

        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket soket = serverSocket.accept();

        }catch (IOException e){

        }
    }
}
