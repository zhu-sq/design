package study.io;

import java.io.*;
import java.net.Socket;

/*
 *java的比较常用的IO
 *  IO是java对数据抽象出来的一种东西，其掩盖了内部键盘，文件等的操作，使程序员更加方便使用
 *  IO是单向的，分为input和output两种流
 *  IO有两种流类型 字节流 和 字符流
 */
public class IO {
    public void main(String[] args){

    }

    //文件的输入输出流
    public void fileStream(String path,String targetPath) throws IOException{

        //字符流
        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);

        byte[] bytes = new byte[1024];
        //读取信息
        while (fileInputStream.read(bytes)!=-1){
            //..
            System.out.println(bytes.toString());
            fileOutputStream.write(bytes);
        }

        fileInputStream.close();
        fileOutputStream.close();


        //字节流
        BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetPath));

        while (bufferedReader.read(bytes)!=-1){
            //..
            System.out.println(bytes.toString());
            bufferedOutputStream.write(bytes);
        }

        bufferedReader.close();
        bufferedOutputStream.close();
    }

    public void socketStream() throws IOException{
        Socket socket = new Socket("",12345);
        BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

        out.flush();
        in.close();
        out.close();
    }

    public void compare() throws  IOException{
        //字符流
        FileInputStream fin1 = new FileInputStream("E:\\WorkSpace\\JavaProject\\Study\\a.txt");
        FileInputStream fin2 = new FileInputStream("E:\\WorkSpace\\JavaProject\\Study\\b.txt");



    }
}
