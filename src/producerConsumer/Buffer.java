package producerConsumer;

public class Buffer {
    private int data;
    private boolean hasData;
    final Object lock = new Object();


    public void produce(int value) throws InterruptedException {
        synchronized (lock)
        {
            while(hasData)
            {
                lock.wait();
            }
            data = value;
            hasData = true;
            lock.notifyAll();
        }
    }
    public int consume() throws InterruptedException {
        synchronized (lock)
        {
            while(!hasData)
            {
                lock.wait();
            }
            hasData = false;
            lock.notifyAll();
            return data;
        }

    }
}
