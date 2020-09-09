package com.grf.pattern.Strategy;

public class AStrategy implements  IStrategy {
    @Override
    public void operate() {
        System.out.println("我是A");
    }
}
