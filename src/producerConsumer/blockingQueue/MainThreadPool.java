package producerConsumer.blockingQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.ArrayList;

public class MainThreadPool {
    public static void main(String[] args) throws InterruptedException {


        BlockingTaskQueue blockingTaskQueue = new BlockingTaskQueue(5);
        ArrayList<Thread> list = new ArrayList<>();
        int Workers = 3;
        for(int i = 0;i < Workers;i++)
        {
            Thread t = new Thread(new Worker(blockingTaskQueue));
            list.add(t);
            t.start();
        }

        //Submit the tasks
        for(int i = 1;i <= 10;i++)
        {
            int finalI = i;
            blockingTaskQueue.put(() ->
            {
                System.out.println("Task "+ finalI +" executed by "+Thread.currentThread().getName());
            });
        }

        for(Thread worker:list)
        {
            worker.interrupt();
        }
    }
}

