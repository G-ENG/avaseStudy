package com.grf.concurrent;

import java.util.concurrent.*;


public class ScheduledTest {


    private static ScheduledExecutorService start = Executors.newScheduledThreadPool(5);
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("---------------------- " + i + " -----------------------");
            start.execute(new TestRunnable());
        }
        start.shutdown();
        makeThreadSleep(cachedThreadPool);


        for (int i = 0; i < 10; i++) {
            System.out.println("---------------------- " + i + " -----------------------");
            fixedThreadPool.execute(new TestRunnable());
        }
        fixedThreadPool.shutdown();
        makeThreadSleep(fixedThreadPool);
    }

    private static void makeThreadSleep(ExecutorService fixedThreadPool) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
