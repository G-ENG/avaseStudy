package com.grf.mutimode;

public class Main {
    public static void main(String[] args) {
        Base childA = new ChildA();
        System.out.println(childA.i);//输出为0，访问的是 Base
        System.out.println(childA.getJ());//输出为1,调用方法时动态绑定

        ChildA realChildA = new ChildA();
        System.out.println(realChildA.i);//输出1
        System.out.println(realChildA.getJ());//输出1

    }
}
