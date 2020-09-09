package com.grf.Reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Reflex{

    public static void main(String[] arg) throws Exception {

        //获取class类 3种
        //1.直接获取
        Class<Test> testClass = Test.class;
        //2.通过对象获取
        Test test = new Test();
        Class aClass = test.getClass();
        //3.通过类全限定名获取
        Class<?> test2 = Class.forName("com.grf.Reflex.Test");

        //创建对象,
        // 1.通过class对象.newIInstance或者获取
        Object o1 = test2.newInstance();
        //2.无参构造器
        Constructor constructor1 = test2.getConstructor();
        Object o2 = constructor1.newInstance();
        //3.有参构造器
        Constructor constructor2 = test2.getConstructor(int.class, String.class);
        Object o3 = constructor2.newInstance(1,"grf");

        //调用方法
        Method method = test2.getMethod("setI", int.class);
        method.invoke(o1, 2);
    }

}
