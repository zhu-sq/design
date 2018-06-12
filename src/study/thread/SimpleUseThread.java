package study.thread;

import java.util.concurrent.*;

/**
 * 线程实现的三种方法
 *    1.继承Thread类
 *    2.实现Runnable接口
 *    3使用Callable和Future创建线程
 */
public class SimpleUseThread {
    public static void main(String[] args){

        //继承Thread的简单线程
        SimpleUseThread simple = new SimpleUseThread();
        MyThred myThred = simple.new MyThred();
        myThred.start();

        //实现Runnable 接口的线程
        MyRunnable myRunnable = simple.new MyRunnable();
        myRunnable.run();

        MyCallable myCallable0 = simple.new MyCallable(0);
        MyCallable myCallable1= simple.new MyCallable(1);
        MyCallable myCallable2 = simple.new MyCallable(2);

        ExecutorService es = Executors.newFixedThreadPool(3);
        try{
            Future future0=null;
            future0=es.submit(myCallable0);
            System.out.println("task1: " + future0.get());
            Future future2 = es.submit(myCallable1);
            // 等待5秒后，再停止第二个任务。因为第二个任务进行的是无限循环
            Thread.sleep(5000);
            System.out.println("task2 cancel: " + future2.cancel(true));
            // 测试抛出异常
            Future future3 = es.submit(myCallable2);
            System.out.println("task3: " + future3.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        es.shutdownNow();
    }

    class MyCallable implements Callable<String>{
        private int flag = 0;
        public MyCallable(int flag) {
            this.flag = flag;
        }
        @Override
        public String call() throws Exception{
            // 情况一：flag=0 返回0
            if (this.flag == 0) {
                return "flag = 0";
            }
            // 情况二：flag=1 返回looping 陷入死循环
            if (this.flag == 1) {
                try {
                    while (true) {
                        System.out.println("looping.");
                        Thread.sleep(2000);
                    }
                    // 情况三：出现异常
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                return "false";
            } else {
                throw new Exception("Bad flag value!");

            }

        }
    }


    class MyThred extends Thread{
        @Override
        public void run(){
            System.out.println("this is my Thread");
        }
    }

    class MyRunnable implements Runnable{
        @Override
        public void run(){
            System.out.println("this is my Runnable");
        }
    }
}
