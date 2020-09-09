package com.grf.concurrent;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"被调用");
    }
}
