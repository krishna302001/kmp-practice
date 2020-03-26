package com.kmp.threads;

import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();

        Thread thread1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                System.out.println("Producer got interrupted");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                System.out.println("Consumer got interrupted");
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}

class PC {
    LinkedList<Integer> linkedList = new LinkedList<>();

    final int capacity = 3;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                if (linkedList.size() == capacity) {
                    wait();
                }
                System.out.println("Produced value: " + value);
                linkedList.add(value++);
                notify();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (linkedList.size() == 0) {
                    wait();
                }
                System.out.println("Consumed: " + linkedList.removeFirst());
                notify();
//                Thread.sleep(1000);
            }

        }
    }
}