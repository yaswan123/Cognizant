import java.util.concurrent.*;
import java.util.*;

public class Main41 {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = Arrays.asList(
            () -> "Task 1",
            () -> "Task 2",
            () -> "Task 3"
        );

        List<Future<String>> results = new ArrayList<>();
        for (Callable<String> task : tasks) {
            results.add(executor.submit(task));
        }

        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        executor.shutdown();
    }
}
