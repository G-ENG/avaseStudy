package com.grf.pattern.adapter;

/**
 * 实现TxtReader接口但是实际上用的是LogReader
 */
public class TxtAdapterLog implements TxtReader {

    private LogReader logReader;

    public TxtAdapterLog(LogReader logReader){
    this.logReader=logReader;
    }

    @Override
    public void readTxt(String fileName) {
        System.out.println("-------通过适配器-------");
        logReader.readLog(fileName);
    }

}
