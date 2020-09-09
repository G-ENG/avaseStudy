package com.grf.lambda;

public class Main {
    public static void main(String[] args) {
        new AClass(new MyFunctionalInterface() {
            @Override
            public String method(String s) {
                return s + "world";
            }
        }).printInfo();

        //->左侧表示参数，右侧表达式直接是返回值
        new AClass((String s) -> s + "world").printInfo();

        //另外一种写法，加了括号要使用return
        new AClass((String s) -> {
            return s + "world";
        }).printInfo();
    }

}
