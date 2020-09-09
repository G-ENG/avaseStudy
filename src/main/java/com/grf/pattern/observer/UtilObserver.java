package com.grf.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class UtilObserver implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我跟你讲哦："+o.getClass().getName()+"变了状态-→"+arg);
    }
}
