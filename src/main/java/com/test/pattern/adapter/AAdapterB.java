package com.test.pattern.adapter;

public class AAdapterB implements A  {

    private B b;

    public AAdapterB(B b) {
        this.b = b;
    }

    @Override
    public void read() {
        b.read();
    }
}
