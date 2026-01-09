package producerConsumer.singleSlot;
import java.util.ArrayList;
import java.util.List;

public class MainSingleSlot {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        int producers = 1;
        int consumers = 5;

        List<Thread> producerThreads = new ArrayList<>();


        for (int i = 0; i < producers; i++) {
            Thread p = new Thread(new Producer(buffer), "Producer-" + i);
            producerThreads.add(p);
            p.start();
        }


        for (int i = 0; i < consumers; i++) {
            new Thread(new Consumer(buffer), "Consumer-" + i).start();
        }


        for (Thread p : producerThreads) {
            p.join();
        }


        for (int i = 0; i < consumers; i++) {
            buffer.produce(Producer.POISON);
        }

        System.out.println("Main exiting cleanly");
    }
}
