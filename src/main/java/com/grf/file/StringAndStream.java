package com.grf.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 */
public class StringAndStream {


    /**
     * Test自动化测试，不支持控制台人工输入输出
     * 介绍了如何将 String 转化为输入流，并 system.setIn
     * 以及输出流如何
     */
    @Test
    public void stringToStream() {

        String string = "12 12 111";
        InputStream systemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(string.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
        } finally {
            System.setIn(systemIn);
        }


    }

    /**
     * 该方法将字符串转为输入流对象，又把输入流对象转为字符串
     */
    @Test
    public void streamToString() {
        String string = "hello world!";
        ByteArrayInputStream tInputStream = new ByteArrayInputStream(string.getBytes());
        System.out.println("字符串 "+string+" 转化为输入流："+tInputStream.getClass());
        try {
            BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
            StringBuilder tStringBuffer = new StringBuilder();
            String sTempOneLine = new String("");
            while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                tStringBuffer.append(sTempOneLine);
            }
            System.out.println("输入流转化为字符串对象:"+tStringBuffer.toString().getClass());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}