package com.kmp.multithread;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EvenOddByThreads {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Task> taskList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            taskList.add(new Task(i));
        }

//        List<Future<Task>> futures = es.invokeAll(taskList);


//        for (Future<Task> future : futures) {
//            System.out.println(future.get());
//        }
    }
}

class Task implements Runnable {
    int n;

    public Task(int n) {
        this.n = n;
    }

    @Override
    public void run() {

        if (n % 2 == 0) {
            System.out.println(this.n + " is even");
        } else {
            System.out.println(this.n + " is odd");
        }
    }
}