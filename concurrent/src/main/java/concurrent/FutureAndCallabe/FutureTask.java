package concurrent.FutureAndCallabe;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class FutureTask<T> implements RunnableFuture<T> {

    private volatile int state;
    private static final int NEW = 0;
    private static final int COMPLETING = 1;
    private static final int NORMAL = 2;
    private static final int EXCEPTIONAL = 3;
    private static final int CANCELLED = 4;
    private static final int INTERRUPTING = 5;
    private static final int INTERRUPTED = 6;
    private volatile WaitNode waiters;

    private Callable<T> callable;
    private T outcome;

    public FutureTask(Callable<T> callable) {
        this.callable = callable;
        state = NEW;
    }

    public void run() {

        try {
            T result = callable.call();
            set(result);

            LockSupport.unpark(waiters.thread);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void set(T result) {
        outcome = result;
        state = COMPLETING;
    }

    public boolean cancel(boolean a) {
        return true;
    }

    public boolean isCancel() {
        return true;
    }


    public boolean isDone() {
        return state == COMPLETING ? true : false;
    }

    public T get() {
        if (state < COMPLETING)
            awaitDone(false, 0L);
        return outcome;
    }

    public T get(long timeout, TimeUnit unit) {
        if (state < COMPLETING)
            awaitDone(true, unit.toNanos(timeout));
        return outcome;
    }

    private int awaitDone(boolean timed, long nanos) {
        WaitNode q = new WaitNode();
        //q.next = waiters;
        waiters = q;
        LockSupport.park(this);
        return 0;
    }

    static final class WaitNode {
        volatile Thread thread;
        volatile WaitNode next;

        WaitNode() {
            thread = Thread.currentThread();
        }
    }
}
