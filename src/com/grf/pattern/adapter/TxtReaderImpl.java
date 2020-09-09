package com.grf.pattern.adapter;

public class TxtReaderImpl implements TxtReader {


    @Override
    public void readTxt(String fileName) {
        System.out.println("我是TxtReader在读:"+fileName);
    }
}
