package com.grf.pattern.adapter;

import org.junit.Test;

import java.util.Scanner;

public class TxtComputerImpl implements TxtComputer {

    /**
     *
     * @param txtReader
     * @param fileName
     * read方法只接受 txtReader ，但我们经过适配器也可以读 log
     */
    @Override
    public void read(TxtReader txtReader, String fileName) {
        System.out.println("我是只能读txt的computer");
        txtReader.readTxt(fileName);
    }

    public static void main(String[] args) {
      /*  Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
        }*/
        TxtReader txtReader = null;
        String str = "hello.log";
        String[] split = str.split("\\.");
        if (split[split.length - 1].equalsIgnoreCase("txt")) {
            txtReader = new TxtReaderImpl();
        } else if (split[split.length - 1].equalsIgnoreCase("log")) {
            txtReader = new TxtAdapterLog(new LogReaderImpl());
        }
        txtReader.readTxt(str);

    }


}
