package com.grf.pattern.observer;


import java.util.LinkedList;
import java.util.List;

/**
自己写的观察者模式
 */
public class ISubject {


    private List<Observer> observers=new LinkedList<>();

    private  int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public   void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){
        for (Observer observer:observers
             ) {
            observer.update();
        }
    }

    static class Observer{
        void update(){
            System.out.println("我跟你讲哦，subject变心了");
        }
    }

    public static void main(String[] args) {
        ISubject subject = new ISubject();
        subject.addObserver(new Observer());
        subject.setState(2);

    }

}
