package com.grf.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy {

    interface IService {
        void sayHello();
    }

    static class RealService implements IService {
        @Override
        public void sayHello() {
            System.out.println("hello world！");
        }
    }


    /**
     * 创建代理类
     */
    static class SayHelloInvocationHandler implements InvocationHandler {
        private IService realService;
        SayHelloInvocationHandler(IService realService) {
            this.realService = realService;
        }
        /**
         * @param proxy 代理者
         * @param method 方法
         * @param args   方法参数
         * @return 返回值
         * @throws Throwable 异常
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("我作为动态代理先说一句哈");
            return method.invoke(realService, args);
        }
    }


    static class CommonInvocationHandler<T> implements InvocationHandler {
        private T t;
        CommonInvocationHandler(T t) {
            this.t = t;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理的优点在于通用性,我可以作为通用的代理");
            return method.invoke(t, args);
        }
    }


    public static void main(String[] args) {
        IService realService = new RealService();
        //基于接口的动态代理，第二个参数是接口数组，强转类型要求也是接口，不能使用具体类型
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[]{IService.class}, new SayHelloInvocationHandler(realService));
        proxyService.sayHello();
        //下面演示通用性，针对不同的接口可以有同样的代理CommonInvocationHandler
        IService proxyService2 = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[]{IService.class}, new CommonInvocationHandler<>(realService));
        proxyService2.sayHello();
    }
}
