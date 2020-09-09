package com.test.pattern.adapter;

public class Main {
    public static void main(String[] args) {
        AImpl a = new AImpl();
        BImpl b = new BImpl();
        AAdapterB aAdapterB = new AAdapterB(b);
        onlyA(a);
        System.out.println("------使用了适配器-------");
        onlyA(aAdapterB);
    }

    private static void onlyA(A a){
        System.out.println("我是只支持A方法");
        a.read();
    }
}
