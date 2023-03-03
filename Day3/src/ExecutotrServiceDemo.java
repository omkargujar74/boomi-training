import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class IncrementCounter implements Runnable {
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        counter.incrementAndGet();
        System.out.println(counter);
    }
}

public class ExecutotrServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        //creating 100 new threads
        for (int i = 0; i < 100; i++) {
            executorService.execute(new IncrementCounter());
        }
        executorService.shutdown();
    }
}
