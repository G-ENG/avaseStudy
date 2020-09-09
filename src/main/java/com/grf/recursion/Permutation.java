package com.grf.recursion;

import java.util.Arrays;

public class Permutation {

    private <T> void swap(T[] array, int i, int j) {
        if (i == j) return;
        T x = array[i];
        array[i] = array[j];
        array[j] = x;
    }
    static int count=0;
    private <T> void permutation(T[] array, int start, int end) {
        if (start == end) {
            count++;
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                permutation(array, start+1, end);
                swap(array, start, i);
            }
        }
    }

    public <T> void permutation(T[] array) {
        permutation(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permutation(new Integer[] {1, 2, 3, 4});
        System.out.println(count);
    }

}