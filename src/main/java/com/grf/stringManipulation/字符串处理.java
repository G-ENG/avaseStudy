package com.grf.stringManipulation;

public class 字符串处理 {
	public static void main(String[] args) {
		System.out.println(x1(9876673));
		System.out.println(x2("12马马马天成马天成、马天成"));
		System.out.println(x3("12马马马天成马天成、马天成"));
		System.out.println(x2("12马马马天成马天成马天成"));
		System.out.println(x3("12马马马天成马天成马天成"));
	}
	// 将int数，按照从右往左返回不含重复数字的新数
	static int x1(int var) {
		Integer in=new Integer(var);
		String str = String.valueOf(var);
		StringBuffer buff = new StringBuffer();
		for (int i = str.length()-1; i >=0; i--) {
			char ch = str.charAt(i);
			if (i == str.lastIndexOf(ch)) {
				buff.append(ch);
			}
		}
		String ans = new String(buff);
		return Integer.parseInt(ans);
	}
	
	//统计一个字符串中有多少个马天成
	static int x2(String str) {
		String[] tmp=str.split("");
		int count=0;
		for (int i = 0; i < tmp.length-2; i++) {
			if(tmp[i].equals("马")&&tmp[i+1].equals("天")&&tmp[i+2].equals("成"))
				count++;
		}
		return count;
	}

	static int x3(String str) {
	return (str+" ").split("马天成").length-1;
	}
	
}