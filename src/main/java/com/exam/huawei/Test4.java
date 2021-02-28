package com.exam.huawei;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 *
 * 输入例子1:
 * 8
 *
 * 输出例子1:
 * 6
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/27
 */
public class Test4 {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String next = scanner.next();
            int i = Integer.parseInt(next);
            ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(i);
            for (int i1 = 0; i1 < i; i1++) {
                arrayBlockingQueue.offer(i1);
            }
            int num =0;
            while (arrayBlockingQueue.size()>1){
                Integer current = arrayBlockingQueue.poll();
                if(num++%3 != 2){
                    arrayBlockingQueue.offer(current);
                }
            }
            System.out.println(arrayBlockingQueue.poll());
        }

    }
}
