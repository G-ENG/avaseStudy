package com.grf.Enum;

import java.util.Random;

public class EnumRandom {
    enum Money{
        $100,$200,$300,$400,$500,$600,$700,$800
    }

    public static <T extends Enum<T>> T newRandomEnumValue(Class<T> t){
        Random random = new Random();
        T[] enumConstants = t.getEnumConstants();
        int i = random.nextInt(enumConstants.length);
        return enumConstants[i];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
        Money money = newRandomEnumValue(Money.class);
        System.out.println(money.name());
        }
    }
}
