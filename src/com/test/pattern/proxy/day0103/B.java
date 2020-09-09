package com.test.pattern.proxy.day0103;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class B implements InvocationHandler {
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        for (Object obj:
             args) {
            System.out.println(obj);
        }
        Object result = method.invoke(a, args);
        return  result;
    }
}
