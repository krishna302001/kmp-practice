package com.kmp.threads;

class MyRunnable implements Runnable {
    private  ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    @Override
    public void run() {

        integerThreadLocal.set((int) (Math.random() * 100D));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integerThreadLocal.get());
    }
}

public class ThreadLocalExample {

    public static void main(String args[]) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread t1 = new Thread(sharedRunnableInstance);
        Thread t2 = new Thread(sharedRunnableInstance);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    }

}
