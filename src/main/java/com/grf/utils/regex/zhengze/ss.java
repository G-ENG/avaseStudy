package com.grf.utils.regex.zhengze;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ss {
    @Test
    public void test(){
       // String s=".+?(?=\\.txt)";
         String s="\\w+?"+"\\.txt";
        Pattern p=Pattern.compile(s);
        Matcher matcher=p.matcher("a.txt,b.txt.c.txt d.txt");
        System.out.println("a.txt,b.txt.c.txt d.txt".matches(s));
        System.out.println(matcher.matches());
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("a.txt,b.txt.c.txt d.txt".replaceAll(s, "grf"));
        System.out.println("a.txt,b.txt.c.txt d.txt".replaceFirst(s, "grf"));


    }
}
