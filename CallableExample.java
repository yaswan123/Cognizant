import java.util.concurrent.*;
import java.util.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> "Task 1 result",
            () -> "Task 2 result",
            () -> "Task 3 result"
        );

        List<Future<String>> results = new ArrayList<>();

        for (Callable<String> task : tasks) {
            results.add(executor.submit(task));
        }

        for (Future<String> future : results) {
            System.out.println("Result: " + future.get());
        }

        executor.shutdown();
    }
}
