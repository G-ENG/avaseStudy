package com.test.pattern.proxy.day0103;

public class A implements IA {
    private int state=1;
   public int changeState(int i){
        state=i;
        return i;
    }
}
