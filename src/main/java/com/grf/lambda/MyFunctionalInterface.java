package com.grf.lambda;

/*
    该注解表明可用lambda语法，生成匿名类
 */
@FunctionalInterface
interface MyFunctionalInterface {
    //只能是含有一个抽象方法
    String method(String s);
}
