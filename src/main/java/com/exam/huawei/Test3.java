package com.exam.huawei;

/**
 *
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 *
 * 输出描述:
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 *
 * 输入例子1:
 * 0xA
 * 0xAA
 *
 * 输出例子1:
 * 10
 * 170
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/27
 */
import java.util.*;
public class Test3 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(Long.parseLong(next.substring(2), 16));
        }

    }
}
