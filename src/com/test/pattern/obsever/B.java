package com.test.pattern.obsever;

import java.util.Observable;
import java.util.Observer;

public class B implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.getClass().getName()+"状态已经变化为"+arg);
    }
}
