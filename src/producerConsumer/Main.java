package producerConsumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer();

        int producers = 3;
        int consumers = 2;

        List<Thread> producerThreads = new ArrayList<>();

        // start producers
        for (int i = 0; i < producers; i++) {
            Thread p = new Thread(new Producer(buffer), "Producer-" + i);
            producerThreads.add(p);
            p.start();
        }

        // start consumers
        for (int i = 0; i < consumers; i++) {
            new Thread(new Consumer(buffer), "Consumer-" + i).start();
        }

        // 🔑 WAIT FOR ALL PRODUCERS
        for (Thread p : producerThreads) {
            p.join();
        }

        // 🔑 SEND POISON PILLS (ONCE)
        for (int i = 0; i < consumers; i++) {
            buffer.produce(Producer.POISON);
        }

        System.out.println("Main exiting cleanly");
    }
}

