package producerConsumer;
import producerConsumer.Producer;
public class Consumer implements Runnable{

    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {


            try {
                while(true)
                {
                    int value = buffer.consume();
                    if(value==Producer.POISON)
                    {
                        System.out.println(Thread.currentThread().getName()+" receives poison, stooped.");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+"consumes :" +value);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
