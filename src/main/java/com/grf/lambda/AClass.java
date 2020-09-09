package com.grf.lambda;

public class AClass {
    private MyFunctionalInterface myFunctionalInterface;

    public AClass(MyFunctionalInterface myFunctionalInterface) {
        this.myFunctionalInterface = myFunctionalInterface;
    }

    void printInfo(){
        System.out.println(myFunctionalInterface.method("hello "));
    }
}
