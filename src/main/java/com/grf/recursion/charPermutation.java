package com.grf.recursion;
/**
 * 输入可能含有重复元素的字符，输出可能的字符串组合
 * set和list之间可以通过构造函数转换
 */

import java.util.*;

public class charPermutation {

    private ArrayList<String> ans=new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        char[] ch=str.toCharArray();
        PermutationHelp(ch,0,ch.length-1);
        Set<String> set = new HashSet<>(ans);
        ArrayList<String> ans1 = new ArrayList<String>(set);
        Collections.sort(ans1);
        return ans1;

    }

    private   void PermutationHelp(char[] arr,int start,int end){
        if(start==end){
            StringBuffer stringBuffer=new StringBuffer();
            for(char x:arr){
                stringBuffer.append(x);
            }
            ans.add(new String(stringBuffer));
        }
        else{
            for(int i=start;i<=end;i++){
                swap(arr,start,i);
                PermutationHelp(arr,start+1,end);
                swap(arr,start,i);
            }
        }

    }

    private static void swap(char[] arr,int start ,int end){
        if(start==end) return;
        char tmp=arr[start];
        arr[start]=arr[end];
        arr[end]=tmp;
    }}
