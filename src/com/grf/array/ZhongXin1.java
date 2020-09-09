package  com.grf.array;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个数组，每个元素代表下次能走的最大范围，要求最快走完数组（不是走到最后一个元素，超出也可以）的路径
 * 例如 输入【1，1，1】 输入【0，1】
 * 输入【2，3，4，1】 输出【0，2】
 * 输入【1，2，2，1】输出【0，1】
 */
public class ZhongXin1 {
    private static List<Integer> reOrderArray(int x, List<Integer> list) {
        Integer[] arr=list.toArray(new Integer[0]);
        List<Integer> ans=new LinkedList<>();
        int len=0;
        int maxNum=0;
        int lenNex=0;
        while(len<arr.length-1){
            ans.add(len);
            for (int i = 1; i <= arr[len]; i++) {
                maxNum=0;
                if(len+i>=arr.length){
                    break;
                }
                if(arr[len+i]>maxNum){
                    maxNum=arr[len+i];
                    lenNex=i;
                }
            }
            len=len+lenNex;
        }
        return ans;
    }

    @Test
    public void tt(){
        List<Integer> lst=new LinkedList<>();
        lst.add(1);//0
        lst.add(2);//1
        lst.add(2);//3
        lst.add(1);
        List<Integer> lst1=reOrderArray(5,lst);
        for (Integer integer : lst1) {
            System.out.println(integer);
        }
    }

}



