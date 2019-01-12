package concurrent.FutureAndCallabe;

public interface RunnableFuture<T> extends Future<T>, Runnable{
    void run();
}
