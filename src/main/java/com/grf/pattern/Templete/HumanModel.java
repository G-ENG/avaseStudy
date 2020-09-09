package com.grf.pattern.Templete;

public abstract class HumanModel {

    //注意 protected 只提供给子类修改
    protected abstract void methodA();
    protected abstract void methodB();

    //final public 固定的外部调用方法
    final public void commonMethod(){
        System.out.println("公共的方法,试一下调用A、B:");
        methodA();
        methodB();
    }
}
