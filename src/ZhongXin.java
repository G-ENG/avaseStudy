
import  java.util.*;

/**
 * 判断输入的字符串数组能否首位相连，相连的含义为上个字符串的为字母与当前字符串的首字母相同
 */
public class ZhongXin {
    public static void main(String[] arg) {
        List<Character> lst1 = new LinkedList<>();
        List<Character> lst2 = new LinkedList<>();
        for (String s : arg) {
            lst1.add(s.charAt(0));
            lst2.add(s.charAt(s.length() - 1));
        }
        List<Character> lst2_bak=lst2;
        int count = 0;
        for (char x : lst1) {
            if (lst2.indexOf(x) != -1) {
                lst2.remove(lst2.indexOf(x));
            } else {
                count++;
            }
        }
        for (char x : (Iterable<Character>) lst2_bak) {
            if (lst1.indexOf(x) == -1) {
                count++;
            } else {
                lst1.remove(lst1.indexOf(x));
            }
        }
        if (count > 2) {
            System.out.println(-1);
        } else {
            System.out.println(1);
        }
    }
}
