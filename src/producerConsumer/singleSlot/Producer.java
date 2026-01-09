package producerConsumer.singleSlot;

public class Producer implements Runnable{
    Buffer buffer;

    public static final int POISON = -1;

    public Producer(Buffer buffer) {
        this.buffer = buffer;

    }

    @Override
    public void run() {
        for(int i = 0;i < 10;i++)
        {
            try {
                buffer.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() +" produces: "+i);
        }

    }
}
