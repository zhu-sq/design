package study.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleUse {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5)
        );

        SimpleUse simpleUse = new SimpleUse();
        for (int i=0;i<10;i++){
            Mytask mytask= simpleUse.new Mytask(i);
            executor.execute(mytask);
            System.out.printf("线程池中的线程数目%d\n队列中等待执行的任务数目%d\n已执行完的任务数目%d\n\n",executor.getPoolSize()
            ,executor.getQueue().size(),executor.getCompletedTaskCount());
        }
        System.out.printf("线程池中的线程数目%d\n队列中等待执行的任务数目%d\n已执行完的任务数目%d\n\n",executor.getPoolSize()
                ,executor.getQueue().size(),executor.getCompletedTaskCount());
        executor.shutdown();
    }


    class Mytask implements Runnable{
        private int taskNum;
        public Mytask(int taskNum){
            this.taskNum=taskNum;
        }
        @Override
        public void run(){

            System.out.printf("开始执行task：%d\n",taskNum);
            try{
                Thread.currentThread().sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.printf("task：%d 执行完毕\n",taskNum);
        }
    }
}
