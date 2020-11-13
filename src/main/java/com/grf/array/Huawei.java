package com.grf.array;



import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 最小步长计算,第一步任意，之后每一步走当前元素上的值，最后走到最后一个元素，最少要走多少步
 */

public class Huawei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lst = new LinkedList<>();

        //while循环，多次查找最少步数
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            //如果输入exit则退出，功能结束
            if (str.equals("exit")) {
                break;
            }
            String[] strArray = str.split(" ");
            int[] intArray = new int[strArray.length];
            int x = 0;
            for (String string : strArray
            ) {
                intArray[x++] = Integer.parseInt(string);
            }


            for (int i = 1; i < intArray.length - 1; i++) {
                int count = 1;
                int len = i;
                while (len < intArray.length - 1) {
                    len = len + intArray[len];
                    count++;
                }
                if (len == intArray.length - 1) {
                    lst.add(count);
                }
            }
            Collections.sort(lst);
            if (lst.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(lst.get(0));
            }
        }
    }

    //public static final Logger LOG = LoggerFactory.getLogger(Huawei.class);

}
