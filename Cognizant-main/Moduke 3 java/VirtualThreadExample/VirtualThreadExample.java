public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[100_000];

        for (int i = 0; i < 100_000; i++) {
            int finalI = i;
            threads[i] = Thread.startVirtualThread(() -> {
                System.out.println("Virtual thread #" + finalI);
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Completed 100,000 virtual threads in " + (end - start) + " ms");
    }
}
