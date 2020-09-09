package com.grf.pattern.decorator;

public class ScoreImpl implements Score {
    @Override
    public void report() {
        System.out.println("数学成绩:"+Score.mathScore);
    }

    @Override
    public void sign() {
        System.out.println("请签字：");
    }
}
