import org.junit.Test;

import java.util.*;

public class test {


     public static class inn{

     }




    public  String ReverseSentence(String str) {
        if (str == null || str.length()<=1) {
            class xx{
                 int a=1;
            }
            return str;
        }
        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length / 2; i++) {
            String tmp = strArray[i];
            strArray[i] = strArray[strArray.length - 1 - i];
            strArray[strArray.length - 1 - i] = tmp;
        }
        StringBuffer ans = new StringBuffer();
        for (String s : strArray) {
            ans.append(s);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return new String(ans);
    }
    public boolean isContinuous(int[] numbers) {
        Arrays.sort(numbers);
        List<Integer> lst=new LinkedList();
        int zeroCount=0;
        for(int i:numbers){
            if(i==0) zeroCount++;
            lst.add(i);
        }
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]==0) continue;
            if(i<numbers.length-1){
                zeroCount=zeroCount-(numbers[i+1]-numbers[i]-1);
            }

        }



        return zeroCount>=0?true:false;
    }
    @Test
    public void test() {
      int[] num={1,0,0,7,0};
        test test = new test();
        System.out.println(test.isContinuous(num));
        System.out.println((int) '2');
        Integer i=123;
        String str=i.toString();
        System.out.println(str);

    }

    @Test
    public void sf(){
       int a=10;
       int b=a++;
       int c=++a;
       int d=10*a++;

        System.out.println(" "+a+" "+b+" "+c+" "+d);
    }
}
