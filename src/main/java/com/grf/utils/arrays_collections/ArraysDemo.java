package com.grf.utils.arrays_collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysDemo {
    public static final Logger LOG = LoggerFactory.getLogger(ArraysDemo.class);


    @Test
   public void testArraysAsList() {
        //Arrays.asList返回的使定长List，无法add，remove
        //括号内以逗号分割直接作为参数
        List<Integer> integers = Arrays.asList(1, 3, 4);
        //int数组
        List<int[]> ints = Arrays.asList(new int[]{1, 3, 3});
        //Integer数组
        List<Integer> ints2 = Arrays.asList(new Integer[]{1,3,4});

    }

    @Test
    public void testArraySort(){
        Integer[] ints = {1, 9, 5, 4, 3};
        Arrays.sort(ints);
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        Arrays.stream(ints).forEach(System.out::print);
    }


    @Test
    public void testArrayToString(){
        System.out.println(Arrays.toString(new int[]{1, 2, 3}));
        System.out.println(Arrays.toString(new Integer[]{1,2,3}));
    }


}
