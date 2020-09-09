package com.grf.pattern.callback;

import org.junit.Test;

public class Caller implements ICaller {


    @Test
    public void call() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始异步处理");
                String s = "Caller:1+1等于几？";
                System.out.println(s+Thread.currentThread().getName());
                System.out.println(Caller.this.hashCode());
                Callee.answer(Caller.this,s);
            }
        }).start();
        System.out.println("Caller：这么久不回，我干别的了"+Thread.currentThread().getName());
        otherOperate();
        System.out.println();

        //保持主线程活着，不然子线程要睡死了
        while (true){
            System.out.println("........");
            Thread.sleep(1000);
        }
    }

    void otherOperate() {
        System.out.println("Caller:我在吃饭....."+Thread.currentThread().getName());
    }

    @Override
    public void callbackMethod(String s) {
        System.out.println(s);
    }

}
