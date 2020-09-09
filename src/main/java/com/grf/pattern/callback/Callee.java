package com.grf.pattern.callback;

public class Callee {
    static void answer(ICaller caller, String s){
        try {
            //模拟被通知者忙于别的
            System.out.println("callee:等一下，我先睡10秒"+Thread.currentThread().getName());
            System.out.println(caller.hashCode());
            Thread.sleep(10000);
            caller.callbackMethod("Callee:答案是2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
