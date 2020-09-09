package com.test.pattern.obsever.day0103;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyObserver {
     interface IObserver{
        void update();
    }

    static class AnObserver implements IObserver{

        @Override
        public void update() {
            System.out.println("变了");
        }
    }

     static class A {
         int state=1;

         public void setState(int state) {
             this.state = state;
             notifyAllObserver();
         }
         List<IObserver> lst=new ArrayList<>();
         void notifyAllObserver(){
             for (IObserver obs :
                     lst) {
                 obs.update();
             }
        }
        void addObserver(IObserver observer){
             lst.add(observer);
        }
    }

    public static void main(String[] args) {
        AnObserver anObserver = new AnObserver();
        A a = new A();
        a.addObserver(anObserver);
        a.setState(3);
    }
}
