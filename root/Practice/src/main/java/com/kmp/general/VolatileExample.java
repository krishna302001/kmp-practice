package com.kmp.general;

class VolatileEaxmple extends Thread {
    volatile boolean isRunning = true;

    public void run() {
        long count = 0;
        while (isRunning) {
            count++;
        }
        System.out.println("Thread terminated. Count is: " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEaxmple t = new VolatileEaxmple();
        t.start();
        Thread.sleep(2000);
        t.isRunning = false;
        t.join();
        System.out.println("isRunning set to " + t.isRunning);
    }
}