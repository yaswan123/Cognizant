public class VirtualThreadsDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread: " + Thread.currentThread());
            });
        }

        long end = System.currentTimeMillis();
        System.out.println("Launched 100,000 virtual threads in " + (end - start) + " ms");

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
