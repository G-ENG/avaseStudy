package com.test.pattern.obsever.day0103;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.addObserver(b);
        a.setState(3);
    }
}
