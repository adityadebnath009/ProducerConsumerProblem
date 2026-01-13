package producerConsumer.blockingQueue;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class MainThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ThreadPool pool = new ThreadPool(10, 4);
        //Submit the tasks
        //Main is acting as a producer

        for(int i = 1;i <= 10;i++)
        {
            int finalI = i;
            pool.execute(() ->
            {
                System.out.println("Task "+ finalI +" executed by "+Thread.currentThread().getName());
            });
        }


        pool.shutdown();

        pool.awaitTermination();


        System.out.println("All Threads are terminated");
    }
}

