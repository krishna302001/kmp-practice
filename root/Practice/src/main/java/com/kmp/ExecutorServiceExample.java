package com.kmp;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceExample {

    public static void main(String args[]) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Processors: " + coreCount);
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        ExecutorService service1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduletedService = Executors.newScheduledThreadPool(coreCount);

        scheduletedService.schedule(new Task(), 10, TimeUnit.SECONDS);
        scheduletedService.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);
        scheduletedService.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        System.out.println();
        service.submit(Task::new);
        //call callableTask
        Future result = service.submit(new CallableTask());
        result.cancel(false);
        try {
            System.out.println(result.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}

class Task implements Runnable {
    public void run() {
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
}

class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() {
        return new Random().nextInt();
    }
}