package com.grf.pattern.proxy;

public class StaticProxy {

     interface IService {
         void sayHello();
    }

    static class RealService implements IService {
        @Override
        public void sayHello() {
            System.out.println("hello world！");
        }
    }

    static class ProxyService implements IService {
        private RealService realService;
        public ProxyService(RealService realService) {
            this.realService = realService;
        }
        @Override
        public void sayHello() {
            System.out.println("代理人我来帮你说");
            realService.sayHello();
        }
    }

    public static void main(String[] args) {
        ProxyService proxyService = new ProxyService(new RealService());
        proxyService.sayHello();
    }
}
