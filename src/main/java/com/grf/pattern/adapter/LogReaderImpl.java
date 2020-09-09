package com.grf.pattern.adapter;

import net.sf.cglib.proxy.Enhancer;

public class LogReaderImpl implements LogReader {
    @Override
    public void readLog(String filename) {
        System.out.println("我是LogReader在读:"+filename);
    }
}
