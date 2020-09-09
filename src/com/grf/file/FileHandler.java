package com.grf.file;


import java.io.*;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * FileOutputStream默认是覆盖原文件，可以使用第二个参数 true 设置为 追加
 */
public class FileHandler {


    public static void main(String[] args) throws IOException {

//使用字节流，一个字节读取，中文字符无法正常显示
        try (
                InputStream in = new FileInputStream(getName());
                OutputStream out = new FileOutputStream(getCopeName(), true)
        ) {

            int a;
            System.out.println("-----------字节读取-------");
            while ((a = in.read()) != -1)// 一个字节读
            {

                System.out.print((char) a);
                //if(count==10) break;
                //读第十个字节给a
                out.write(a);
            }
            String data = "hello,123,耿瑞锋";
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            out.write(bytes);
        }
//使用字节流，数组缓存，
        InputStream in1 = null;
        OutputStream out1 = null;
        try {
            in1 = new FileInputStream("C:\\Users\\13761\\Desktop\\7.29.txt");
            out1 = new FileOutputStream("C:\\Users\\13761\\Desktop\\7.29copy.txt", true);
            byte[] arr1 = new byte[2048];
            int len = in1.read(arr1);
            out1.write(arr1, 0, len);
            System.out.println("\n ----------字节读取 数组缓存-------------");
            System.out.println(new String(arr1, 0, len));
        } finally {
            try {
                if (in1 != null) {
                    in1.close();
                }
                if (out1 != null) {
                    out1.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
// 使用字符流，InputStreamReader实现字节流到字符流的转换
        try (
                FileInputStream fileInputStream = new FileInputStream(getName());
                FileOutputStream fileOutputStream = new FileOutputStream(getCopeName(),true);
                Reader reader = new InputStreamReader(fileInputStream);
                Writer writer = new OutputStreamWriter(fileOutputStream)
        ) {
            int ch;
            System.out.println("\n -----------字节到字符---------------");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
                writer.write(ch);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

//使用字符流 FileReader
        try (Reader reader1 = new FileReader(getName());
             Writer writer1 = new FileWriter(getCopeName(), true)
        ) {
            int ch;
            System.out.println("\n-----------字符流------------");
            while ((ch = reader1.read()) != -1) {
                System.out.print((char) ch);
                writer1.write(ch);
            }
        }

// 使用字符流 BufferedReader 有readline()可用
        try (
                FileReader fileReader = new FileReader(getName());
                FileWriter fileWriter = new FileWriter(getCopeName(), true);
                BufferedReader reader2 = new BufferedReader(fileReader);
                BufferedWriter writer2 = new BufferedWriter(fileWriter)) {
            String ch;
            System.out.println("\n---------------字符流 buffered--------------");
            while ((ch = reader2.readLine()) != null) {
                System.out.println(ch);
                writer2.write(ch);
                writer2.newLine();
            }
        }

//与键盘屏幕交互
        while (true) {
            byte[] array = new byte[100];
            System.out.println("请输入");
            int len = System.in.read(array);
            String str = new String(array, 0, len - 1);
            if (str.length() == 0)
                continue;
            if ("exit".equals(str)) {
                System.out.println("结束啦");
                break;
            }
            System.out.write(array, 0, len);
        }
//从文件中读第十个字节

    }

    private static String getName() {
        return "C:\\Users\\13761\\Desktop\\7.29.txt";
    }

    private static String getCopeName() {
        return "C:\\Users\\13761\\Desktop\\7.29copy.txt";
    }
}
