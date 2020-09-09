package com.grf.Enum;

public class useSize {
    public static void main(String[] args) {
        System.out.println(Size.LARGE.getIndex());
        //Size.LARGE.setI(33);System.out.println(Size.LARGE.getI());能用但别用
        for (Size value : Size.values()) {
            System.out.println(value.getTitle());
        }
        final Size size = fromIndex(1);
        System.out.println("get "+size + " by Index : " + 1);
    }

    private static Size fromIndex(int i) {
        for (Size value : Size.values()) {
            if (value.getIndex() == i) {
                return value;
            }
        }
        return null;
    }
}
