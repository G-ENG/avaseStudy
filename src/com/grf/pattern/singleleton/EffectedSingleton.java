package com.grf.pattern.singleleton;

// Effective Java 第一版推荐写法
//非常巧妙，只有调用 getInstance 方法 单例对象才会创建
public class  EffectedSingleton {

    private EffectedSingleton(){}

    private static class SingletonHolder{
        private static final EffectedSingleton effectedSingleton = new EffectedSingleton();
    }

    public static EffectedSingleton getInstance(){
        return SingletonHolder.effectedSingleton;
    }

}
