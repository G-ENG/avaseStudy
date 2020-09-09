package com.grf.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileAdvance {
    static class StudentData {
        String name = "耿瑞锋";
        private Date birth = null;

        String getName() {
            return name;
        }

        int getAge() {
            return 18;
        }

        Date getBirth() {
            return birth;
        }

        {
            try {
                String sDate = "1998-07-28";
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                birth = simpleDateFormat.parse(sDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return InputStream
     */
    //字符串到流
    @SuppressWarnings("unused")
    InputStream byteArray2InputStream() {
        String data = "name：耿瑞锋";
        final byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        // ByteArrayOutputStream 类似
        return new ByteArrayInputStream(bytes);
    }


    public void printWriterTest() {
        //先看看不同的writer
        try (Writer writer = new FileWriter("C:\\Users\\13761\\Desktop\\hello.txt", true);
             BufferedWriter writer1 = new BufferedWriter(writer)) {
            writer1.write(65);
            writer1.write('\n');
            writer1.write(new char[]{'4', 97, '\n', '\t'});
            writer1.write("hello world!\n");
            StudentData data = new StudentData();
            writer1.write(String.valueOf(StudentData.class.getDeclaredField("name").get(data)));
            writer1.write("测试结束".toCharArray());

        } catch (IOException | NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }

        /*
          printWriter提供了除字符字节外，多种格式写入文件，与其类似的还有 printStream
         */
        try (final PrintWriter printWriter = new PrintWriter("C:\\Users\\13761\\Desktop\\hello.txt")) {
            final StudentData data = new StudentData();
            printWriter.println(data.getAge());
            printWriter.println(data.getBirth());
            printWriter.print(data.getName());
            printWriter.print("-----------printWriter测试结束------------");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //文件和目录
    //列出目录下为扩展名 .txt 的文件
    private static File[] listTxtFile(File dirName) {
        final File[] files = dirName.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // dir表示父级目录,name 表示文件名
                return name.endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file :
                    files) {
                System.out.println(file.getName());
            }
        }
        return files;
    }

    //统计目录下所有文件的大小（包括子目录）
    private static long sizeOfDirectory(File dir) {
        long size = 0;
        if (dir.isFile()) {
            return dir.length();
        } else {
            for (File file :
                    dir.listFiles()) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += sizeOfDirectory(file);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {

        final File deskTop = new File("C:\\Users\\13761\\Desktop");
        final File[] files = listTxtFile(deskTop);
        System.out.println(setSize(sizeOfDirectory(deskTop)));

    }

    public static String setSize(long size) {
        //获取到的size为：1705230
        final int GB = 1024 * 1024 * 1024;//定义GB的计算常量
        final int MB = 1024 * 1024;//定义MB的计算常量
        final int KB = 1024;//定义KB的计算常量
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String resultSize = "";
        if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB
            resultSize = df.format(size / (float) GB) + "GB ";
        } else if (size / MB >= 1) {
            //如果当前Byte的值大于等于1MB
            resultSize = df.format(size / (float) MB) + "MB ";
        } else if (size / KB >= 1) {
            //如果当前Byte的值大于等于1KB
            resultSize = df.format(size / (float) KB) + "KB ";
        } else {
            resultSize = size + "B ";
        }
        return resultSize;
    }
}


