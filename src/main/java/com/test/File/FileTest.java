package com.test.File;


import java.io.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class FileTest {
    private static long sizeOfDirectory(File dir) {
        long size = 0L;
        if (dir.isFile()) {
            return dir.length();
        } else {
            for (File file :
                    Objects.requireNonNull(dir.listFiles())) {
                if (file.isFile()) {
                    size = size + file.length();
                } else {
                    size = size + sizeOfDirectory(file);
                }
            }
        }
        return size;
    }


    private static String dataFormat(Long oldData) {
        final long GB = 1024 * 1024 * 1024;
        final long MB = 1024 * 1024;
        final long KB = 1024 * 1024;

        final DecimalFormat decimalFormat = new DecimalFormat("0.00");

        if (oldData / GB > 1) {
            return decimalFormat.format(oldData / GB) + "GB";
        } else {
            if (oldData / MB > 1) {
                return decimalFormat.format(oldData / MB) + "MB";
            } else {
                if (oldData / KB > 1) {
                    return decimalFormat.format(oldData / KB) + "KB";
                }
            }
        }
        return oldData + "B";
    }


    public static void main(String[] args) {
        final long l = sizeOfDirectory(new File("C:\\Users\\13761\\Desktop\\HelloSpringWeb"));
        System.out.println(dataFormat(l));
    }

    static void FileIOTest(File fileInput, File fileOutPut) throws IOException {

        try (InputStream fileInputStream = new FileInputStream(fileInput);
             OutputStream fileOutputStream = new FileOutputStream(fileOutPut)
        ) {
            int tag;
            while ((tag = fileInputStream.read()) != -1) {
                fileOutputStream.write(tag);
            }
        }

        try (InputStream fileInputStream = new FileInputStream(fileInput);
             final InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

             final FileWriter   fileWriter = new FileWriter(fileOutPut);
             final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
                bufferedWriter.write(s);
            }
        }

    }

}


