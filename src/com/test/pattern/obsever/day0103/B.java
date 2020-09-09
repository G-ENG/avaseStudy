package com.test.pattern.obsever.day0103;

import java.util.Observable;
import java.util.Observer;

public class B implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.getClass().getName()+"的状态变化为："+arg);
    }
}
