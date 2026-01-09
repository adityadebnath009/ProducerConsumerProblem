package producerConsumer.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingTaskQueue {
    private final int capacity;
    private final Queue<Runnable> q = new LinkedList<Runnable>() ;
    private final Object lock = new Object();

    public BlockingTaskQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(Runnable task) throws InterruptedException {
        if (task == null) {
            throw new NullPointerException("task");
        }

        synchronized (lock)
        {
            while(q.size()==capacity)
            {
                lock.wait();
            }
            q.add(task);
            lock.notifyAll();
        }
    }
    public Runnable take() throws InterruptedException {
        synchronized (lock)
        {
            while(q.isEmpty())
            {
                lock.wait();
            }
            Runnable task = q.poll();

            lock.notifyAll();
            return task;
        }
    }

}
