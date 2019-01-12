package concurrent.FutureAndCallabe;

import java.util.concurrent.TimeUnit;

public interface Future<T> {
    boolean cancel(boolean a) ;
    boolean isCancel();
    boolean isDone();
    T get();
    T get(long timeout, TimeUnit timeUnit);
}
