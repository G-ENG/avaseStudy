package com.test.pattern.adapter;

public class BImpl implements B {
    @Override
    public void read() {
        System.out.println("我有读取B的能力");
    }
}
