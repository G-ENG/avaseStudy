package com.test.pattern.proxy;



import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class CGLibProxyTest {

    static class RealService{
        int sum(int a,int b){
            return a+b;
        }
    }

    static class ProxyService implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("方法名为:" + method.getName());
            System.out.println("参数为：");
            for (Object object:
                 objects) {
                System.out.println(object);
            }
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("结果为：" + result);
            return result;
        }

    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealService.class);
        enhancer.setCallback(new ProxyService());
        RealService o = (RealService) enhancer.create();
        o.sum(1,1);
    }
}
