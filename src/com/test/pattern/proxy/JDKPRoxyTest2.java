package com.test.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKPRoxyTest2 {
    static interface  AInterface{
        String append(String a,String b);
    }

    static class RealService implements  AInterface{
        @Override
        public String append(String a, String b) {
            StringBuffer stringBuffer=new StringBuffer(a);
            stringBuffer.append(b);
            return stringBuffer.toString();
        }
    }

    static class ProxyService implements InvocationHandler {
        AInterface realService;

        public ProxyService(AInterface realService) {
            this.realService = realService;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("参数有：");
            for (Object object :
                    args) {
                System.out.println(object);
            }
            Object result = method.invoke(realService, args);
            System.out.println(result);
            return result;
        }
    }

    public static void main(String[] args) {

        AInterface o = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, new ProxyService(new RealService()));
        o.append("hello","wor1d");
    }
}
