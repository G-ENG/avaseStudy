package com.grf.pattern.decorator;

import java.io.BufferedWriter;
import java.nio.Buffer;

public class HIghScoreDecorator extends ScoreDecorator {
    public HIghScoreDecorator(Score score) {
        super(score);
    }

    @Override
    public void report() {
        System.out.println("我其实分数比上次高很多");
        super.report();
    }
}
