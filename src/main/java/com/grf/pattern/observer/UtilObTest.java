package com.grf.pattern.observer;

public class UtilObTest {


    public static void main(String[] args) {
        UtilObservable utilObservable = new UtilObservable();
        utilObservable.addObserver(new UtilObserver());
        utilObservable.setState(2);
    }

}
