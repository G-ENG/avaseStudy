package com.test.pattern.obsever;

import java.util.Observable;

public class A extends Observable {
    private int state;

    public void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers(state);
    }

    public int getState() {
        return state;
    }


}
