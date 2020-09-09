package com.test.pattern.obsever;

public class Main {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.addObserver(b);
        a.setState(2);
        a.setState(3);
    }
}
