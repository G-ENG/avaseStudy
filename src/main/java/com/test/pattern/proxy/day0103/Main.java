package com.test.pattern.proxy.day0103;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        IA o = (IA) Proxy.newProxyInstance(IA.class.getClassLoader(), new Class<?>[]{IA.class}, new B(new A()));
        o.changeState(2);
    }
}
