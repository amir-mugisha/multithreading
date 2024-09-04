import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main is starting");

        SharedResource sharedResource = new SharedResource(0);

        Thread thread1 = new Thread1("Thread 1", sharedResource);
        thread1.start();

        Thread thread2 = new Thread(new Thread2(sharedResource), "Thread 2");
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final data value: " + sharedResource.getData());



        // ===================== THREAD POOL ===================================

        // Step 1: Create a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Step 2: Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Runnable task = new Task(i);
            executorService.submit(task);
        }

        // Step 3: Shutdown the executor service
        executorService.shutdown();

        try {
            // Wait for all tasks to complete or timeout after 1 hour
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks are finished.");
        System.out.println("Main is exiting");

    }
}