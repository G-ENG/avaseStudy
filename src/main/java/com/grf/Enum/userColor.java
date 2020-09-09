package com.grf.Enum;

public class userColor {
    //enum不能是 local：放在方法内部
     enum Color{
        RED,GREEN
    }
    public static Color changeColor(Color color) {
        switch (color) {
            case RED:
                color = Color.GREEN;
                break;
            case GREEN:
                color = Color.RED;
                break;
        }
        return color;
    }
}
