package com.grf.concurrent.Threadpool;

import org.junit.Test;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ShutdownDemo instant = ShutdownDemo.getInstant();
        try {

            System.out.println("first start");
            instant.start();

            Thread.sleep(10000);
            System.out.println("second start");
            instant.start();

            Thread.sleep(10000);
            System.out.println("stop");
            instant.stop();

            Thread.sleep(10000);
            System.out.println("start after stop");
            instant.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        class RunableTask implements Runnable{

            @Override
            public void run() {
                while (true){
                    System.out.println(".");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }

        class CallAbleTask implements Callable{

            @Override
            public Object call() throws Exception {
                while (true){
                    System.out.println(".");

                        Thread.sleep(100);

                }
            }
        }
        Future<?> submit = executorService.submit(new CallAbleTask());
        Thread.sleep(1000);
        submit.cancel(true);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
