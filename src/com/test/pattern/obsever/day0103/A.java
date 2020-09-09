package com.test.pattern.obsever.day0103;

import java.util.Observable;

public class A extends Observable {
    private int state=1;

    public void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers(state);
    }
}
