package com.grf.pattern.singleleton;

//此种写法缺点在于已经继承enum。不支持继承别的类
public enum EnumSingleton {
    INSTANCE;
    public  void testInstance(){
        System.out.println("success！");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.testInstance();
    }
}
