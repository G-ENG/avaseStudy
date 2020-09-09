package com.grf.utils.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

/**
 * 正则表达式
 * <p>
 * 模式：
 * 单行模式 .也匹配换行符 pattern.DOTALL
 * 忽略大小写:pattern.CASE_INSENSITIVE
 * 多行匹配:pattern.MULTILINE
 * 用法：pattern.compile(regex,pattern.DOTALL|pattern.MULITLINE)
 * <p>
 * 单个字符：匹配 \ . * ? 需要加转义字符 \，在字符串中便是两个\\
 * \d==[0-9] \w==[a-zA-Z_0-9] \s==[\t\n\x0B\f\r]
 * 对应的排除型 \D \W \S
 * <p>
 * 字符组：[abc][a-c] 匹配 abc 中任意一个字符
 * [^abc]    匹配除了 a或b或c 任意一个字符
 * <p>
 * 量词：  ab{1，3}c 匹配abc abbc abbbc
 * ab{0，}c==ab*c  ab{1,}==ab+c  ab{0,1}==ab?c
 * ab*?c 非贪婪
 * <p>
 * 分组：(a|b) 匹配 a 或 b，注意[a|b]匹配 a 或 | 或 b
 * <p>
 * 环绕边界匹配：对左右字符串的要求
 * abc(?=def) 匹配 abcdef 中的 abc
 * abc(?!def) 匹配右侧不为 def 的 abc
 * (?!def)\w{3} 对右侧 \w添加要求不为def
 * (?<=def)abc 匹配 defabc 中的 abc
 * (?<!def)abc 匹配左侧不为 def 的 abc
 * \w{3}(?<!def)对左侧 \w添加要求不为deg
 * <p>
 * 特殊边界匹配: ^[^abc] 匹配不是 a、b、c 的字符开头
 * abc& 匹配以abc结尾
 *
 * 常用匹配
 *      邮编：   (?<!\d)\d{6}(?！\d)
 *
 *      中文字符： [\u4e00-\u9fff]
 *      身份证："(?<![0-9])"//左边不能有数字
 *              +"[1-9][0-9]{5}"//地区
 *              +"[0-9]{12}[0-9xX]?"//二代多的部分
 *              +"(?![0-9])"//右边不能有数字
 */
public class RegexDemo {

    //正则表达式验证
    public static void main(String[] args) {
        //要求密码包含字母大小写和数字
        final String s1 = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])\\w+";

        //密码不符合要求
        String errorKeyWord = "grf123";
        Pattern pattern1 = Pattern.compile(s1);
        Matcher errorKeywordMatcher = pattern1.matcher(errorKeyWord);
        System.out.println(errorKeyWord + "匹配结果：" + errorKeywordMatcher.matches());
        //等同于
        System.out.println(errorKeyWord.matches(s1));

        //密码符合要求
        String rightKeyWord = "Grf123";
        Matcher rightKeywordMatcher = pattern1.matcher(rightKeyWord);
        System.out.println(rightKeyWord + "匹配结果：" + rightKeywordMatcher.matches());
    }

    //查找桌面log.log文件中表示时间的字段
    @Test
    public void findTime() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader("C:\\Users\\13761\\Desktop\\log.log");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
        }

        //满足yyyy-MM-dd时间格式
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            //group表示找到的字符串，start() end()是起始和终止位置
            System.out.println("find:" + matcher.group() + " start:" + matcher.start() + " end:" + matcher.end());
        }
    }


    /*
     *查看桌面 .doc .docx 结尾文件
     */
    @Test
    public void ListWordTypeFile() {
        final String desktopPath = "C:\\Users\\13761\\Desktop\\";
        final String wordRegex = ".+?(\\.dox|\\.docx)$";//匹配 word文件
        final String wordRegex2 = ".+?(\\.dox|\\.docx)$(?<!854.docx)";//匹配除了854.docx 的word文件

        File desktopDir = new File(desktopPath);
        for (File file :
                desktopDir.listFiles()) {
            if (file.isFile()) {
                if (file.getName().matches(wordRegex2)) {
                    System.out.println(file.getName());
                }
            }
        }
    }

    //环视的使用坑
    @Test
    public void matcherTest(){
        //使用matcher.find可以不用考虑环视对开头和结尾造成的影响，使用matches无法避免
        Pattern compile = Pattern.compile("(?<![0-9])[0-9]{6}(?![0-9])");
        Matcher matcher = compile.matcher("123456");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println("123456".matches(" (?<![0-9])[0-9]{6}(?![0-9])"));
        System.out.println("123456".matches("[0-9]{6}"));
    }

}
