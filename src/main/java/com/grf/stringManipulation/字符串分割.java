package com.grf.stringManipulation;

import org.junit.Test;

import java.util.Calendar;

public class 字符串分割 {
	//方法一
	 private static String[] parseStr(char a[]) {
		int i = 0, j = 0;
		String s = "";
		String[] str = new String[a.length];
		for (i = 0; i < a.length; i++) {
			if (a[i] != ' ') {
				s = s + a[i];
			} else {
				str[j++] = s;
				s = "";
			}
		}
		str[j] = s;
		return str;
	}

	
	
	public static void min(String args[]) {
		char[] a = { 'a', ' ', 'b', ' ', '\\','d' };
		for (String str : parseStr(a)) {
			System.out.println(str);
		}
		
		//通过自带split
		//split("")大致等于toCharArray
		//String[] str=new String(a,0,a.length).split("");
		char[] str=new String(a,0,a.length).toCharArray();
		for (char string : str) {
			System.out.println(string);
		}
		System.out.println( String.valueOf("\\123") );
		
	}

	/**
	 * split(regex)与split(regex,limit)区别
	 * split和split(regex,0) 最后的空字符串将会被丢弃
	 */
	@Test
	public void testSplit(){
		String string="12a\\231.?aa2+-123";
		String string2="--e-e--e---";
		String[] split = string2.split("-");//分割后{"","",e,e,"",e}
		String[] split1 = string2.split("-",0);//分割后{"","",e,e,"",e}
		String[] split2 = string2.split("-", -1);//分割后{"","",e,e,"",e,"","",""}
		String[] split3 = string.split("-",1);//分割后{}
		String[] split4 = string2.split("-",2);//分割后{"","-e-e--e---"}
		String[] split5 = string2.split("-",3);//分割后{"","",e-e--e---}
		System.out.println(split.length);
		for (String str :
				split) {
			System.out.println(str);
		}
		System.out.println(split2.length);
		System.out.println("-------------");
		for (String str :
				split2) {

			System.out.println(str);
		}


	}
	
	
}