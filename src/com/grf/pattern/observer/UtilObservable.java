package com.grf.pattern.observer;

import java.util.Observable;

/**
 * 使用java.util实现观察者模式，UtilObservable为被观察者
 */
class UtilObservable extends Observable {


    private int state;

    void setState(int state) {
        this.state = state;
        setChanged();//使用setChanged，notifyObserve后会clearChanger，线程安全
        notifyObservers(state);//可以选择传参给Observer，也可以不传参
    }
}
