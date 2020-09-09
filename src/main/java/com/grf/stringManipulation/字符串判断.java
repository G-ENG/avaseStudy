package com.grf.stringManipulation;

public class 字符串判断 {
	/**
	 * 文档注释
	 * 该文档下面由很多字符串的判断
	 * @param args
	 */
	
	public static void main(String args[]) {
		System.out.println(isNumStr("araf112"));
		System.out.println(isNumStr("211112"));
		System.out.println(isNumLetterStr("111111"));
		System.out.println(isNumLetterStr("aaaaaa"));
		System.out.println(isNumLetterStr("111aaa"));
		System.out.println(isNumLetterStr("111aaa+"));
		System.out.println(isFloatStr(null));
		System.out.println(isFloatStr(""));
		System.out.println(isFloatStr("1"));
		System.out.println(isFloatStr("."));
		System.out.println(isFloatStr("1."));
		System.out.println(isFloatStr(".1"));
		System.out.println(isFloat(null));
		System.out.println(isFloat(""));
		System.out.println(isFloat("1"));
		System.out.println(isFloat("."));
		System.out.println(isFloat("1."));
		System.out.println(isFloat(".1"));
	}

	// 此方法用来判断字符串由数字组成
	private static boolean isNumStr(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!(ch >= '0' && ch <= '9')) {
				return false;
			}

		}
		return true;
	}

	// 此方法判断字符串由字母和数字组成而且长度为6到12个字符
	private static boolean isNumLetterStr(String str) {
		if (str.length() < 6 || str.length() > 12 || str == null) {
			return false;
		}
		boolean isNum = false, isLetter = false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				isNum = true;
			} else if (ch >= 'A' && ch <= 'z') {
				isLetter = true;
			} else
				return false;
		}
		return isLetter && isNum;
	}

// 此方法判断字符串是由数字或数字和一个点组成

	private static boolean isFloat(String str){
		if(str==null||str.length()==0)
		return false;
		for(int i=0,count=0;i<str.length();i++){
			char ch=str.charAt(i);

			if(ch=='.') count++;
			if(!((ch=='.'&&count==1)||(ch>='0'&&ch<='9')))
			return false;
			if(ch=='.'&&str.length()==1)
			return false;
		}
		return true;
	}

//判断字符串是浮点
	private static boolean isFloatStr(String str) {
		// tr补全
		try {
			Float.parseFloat(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//判断字符串由字母和数字组成且长度在6~12之间
	public static boolean isNc(String str) {
		boolean a = false, n = false;
		if (str.length() < 6 || str.length() > 12)
			return false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
				a = true;
			else if (ch >= '0' && ch <= '9')
				n = true;
			else
				return false;
		}
		return a && n;
	}

//判断字符串所表示的数字在5000~8000之间
	public static boolean isNum58(String str) {
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (num >= 5000 && num <= 8000)
			return true;
		else
			return false;
	}

	
	
//判断字符串是由数字和字母组成（既要有大写字母又要有小写字母）
public static boolean isPassStr(String str) {
		int a = 0;
		int A = 0;
		int n = 0;
		for (int i = 0; i < str.length(); i++) {
			int ch=str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				A++;
			else if (ch >= 'a' && ch <= 'z')
				a++;
			else if (ch >= '0' && ch <='9')
				n++;
		}
		return (a > 0 && A > 0 && n > 0);
	}


//	此方法用来翻转字符串，当然你也可以用StringBuffer定义字符串，然后用写好的reverse方法
	static String reverse(String str) {
		if (str == null || str.length() == 0)
			return str;
		String s = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			s = s + str.charAt(i);
		}
		return s;
	}

	// 此方法用来判断字符串中某个字符的个数
	public static int count(String str, char ch) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				cnt++;
			}

		}
		return cnt;
	}

	// 字符串求和
	public static int sum(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int s = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			s = s + (int) ch;
		}
		return s;

	}


	// 此方法判断数组中某一元素个数
	public static int count(int a[], int iKey) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == iKey) {
				cnt++;
			}

		}
		return cnt;
	}

	// 此方法统计数字数组的总和
	public static int sum(int a[]) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s = s + a[i];
		}
		return s;
	}
}