package com.test.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
     interface A{
        int  calculate(int a, int b);
    }

    static class RealA implements A{
        @Override
        public int calculate(int a, int b) {
            return a+b;
        }
    }

    static class ProxyA implements InvocationHandler{

         private  A realA;

        ProxyA(A realA) {
            this.realA = realA;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("方法名为:"+method.getName());
            System.out.println("参数为:");
            for (Object object :
                    args) {
                System.out.println(object);
            }
            Object result = method.invoke(realA, args);
            System.out.println("结果为："+result);
            return result;
        }
    }

    public static void main(String[] args) {
        A o  = (A) Proxy.newProxyInstance(A.class.getClassLoader(),
                new Class[]{A.class}, new ProxyA(new RealA()));
        o.calculate(1,1);
    }
}
