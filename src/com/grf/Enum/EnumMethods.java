package com.grf.Enum;

import org.junit.Test;

public class EnumMethods {
    enum Color {
        READ, GREEN, BLUE
    }

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        for (Color color :
                Color.values()) {
            System.out.println(color.ordinal());//输出序号,0、1、2
            System.out.println(color.name());
            System.out.println(color.compareTo(Color.GREEN));//输出序号差
            System.out.println(color.equals(Color.GREEN));
            System.out.println(color.getDeclaringClass());
            System.out.println("----------------------------");
        }

        //使用 valueOf String→Enum
        Color color = Color.valueOf("GREEN");
        System.out.println(color.ordinal());
        System.out.println(color.equals(Color.GREEN));

        //编译器会对Enum处理，加上values方法
        Class<? extends Color> aClass = color.getClass();
        //此时aClass没有values方法,可用getEnumConstants替代
        Color[] enumConstants = aClass.getEnumConstants();
        for (Color enumConstant : enumConstants) {
            System.out.println(enumConstant.name());
        }

    }

}
