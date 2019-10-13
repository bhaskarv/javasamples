package org.learn.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vinay on 6/10/19.
 */
public class ProducerConsumer1 {
    public static void main(String[] args) {
        BlockingQueue<Item> blockingQueue = new ArrayBlockingQueue<>(10);

        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();

    }

}

class Item {
    private int id;

    public Item(int id) {
        this.id = id;
    }

    public void process() {
        System.out.println(" PROCESSING ITEM "+id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                '}';
    }
}

class Producer implements  Runnable {
    Random random = new Random(10);
    private BlockingQueue<Item> queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void produce() throws Exception {
        Item item = new Item(random.nextInt());
        System.out.println(" PRODUCED ITEM "+item);
        queue.put(item);
    }

    @Override
    public void run()  {
        while(true) {
            System.out.println(" PRODUCING NEW ITEM ");
            try {
                produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements  Runnable {

    private BlockingQueue<Item> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            Item item = null;
            try {
                item = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" CONSUMING ITEM "+item);
            item.process();
        }
    }
}