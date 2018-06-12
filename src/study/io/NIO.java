package study.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {
    public static void main(String[]  args){
         String src="E:\\WorkSpace\\JavaProject\\Study\\test.txt";
         String dst="E:\\WorkSpace\\JavaProject\\Study\\test_dst.txt";
        NIO  nio = new NIO();
        try{
            nio.copyFileUserNIO(src,dst);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public void copyFileUserNIO(String src,String dst) throws IOException{
        FileInputStream fin = new FileInputStream(src);
        FileOutputStream fo = new FileOutputStream(dst);
        FileChannel fcin = fin.getChannel();
        FileChannel fco=fo.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(fcin.read(buffer) != -1){
            buffer.flip();
            fco.write(buffer);
            buffer.clear();
            buffer.compact();

        }
    }
}
