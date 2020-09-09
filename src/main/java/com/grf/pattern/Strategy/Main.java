package com.grf.pattern.Strategy;

public class Main {
    public static void main(String[] args) {
        IStrategy aStrategy = new AStrategy();
        IStrategy bStrategy = new BStrategy();
        new Context(aStrategy).operate();
        new Context(bStrategy).operate();
    }
}
