package com.grf.pattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy {

    //定义一个类
    static class RealService {
        void sayHello() {
            System.out.println("hello world");
        }

        int changeInt(int i) {
            return i;
        }

        void noProxy() {
            System.out.println("no proxy");
        }
    }

    //实现cglib的方法拦截器
    static class SayHelloIntercepter implements MethodInterceptor {
        /**
         * @param o           被增强的对象，sout输出报错
         * @param method      被代理方法
         * @param objects     方法的参数
         * @param methodProxy 代理方法
         * @return 方法的结果
         * @throws Throwable
         */
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("sayHello的代理者------");
            System.out.println("我是被代理的" + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);//使用invoke传参o引起死循环
            return result;
        }
    }

    static class ChangeIntInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("changeInt的代理者-------");
            System.out.println(method.getName()+"开始执行"+"参数有：");
            for (Object obj :
                    objects) {
                System.out.println(obj);
            }
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println(method.getName()+"结果为："+result+'\n');
            return result;
        }
    }

    static class CGlibCallbackFilter implements CallbackFilter {
        //返回的值顺序对应enhancer.setCallbacks中的顺序
        @Override
        public int accept(Method method) {
            if(method.getName().equals("sayHello")){
                return 0;
            }
            else if(method.getName().equals("changeInt")){
                return 1;
            }
            return 2;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }

    static class NoProxyInterceptor implements MethodInterceptor{

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            return methodProxy.invokeSuper(o,args);
        }
    }

    public static void main(String[] args) {
        // 调用动态代理,创建增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealService.class);
        enhancer.setCallbacks(new MethodInterceptor[]{new SayHelloIntercepter(),new ChangeIntInterceptor(),new NoProxyInterceptor()});
        enhancer.setCallbackFilter(new CGlibCallbackFilter());
        RealService o = (RealService) enhancer.create();
        o.sayHello();
        o.changeInt(2);
        o.noProxy();

    }
}
