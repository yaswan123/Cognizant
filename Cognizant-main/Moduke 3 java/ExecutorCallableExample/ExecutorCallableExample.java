import java.util.concurrent.*;
import java.util.*;

public class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int taskNum = i;
            tasks.add(() -> {
                Thread.sleep(500); // simulate work
                return "Result from task " + taskNum;
            });
        }

        List<Future<String>> results = executor.invokeAll(tasks);

        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}
