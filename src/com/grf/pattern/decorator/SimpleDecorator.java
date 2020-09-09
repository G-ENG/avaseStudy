package com.grf.pattern.decorator;

public class SimpleDecorator {
    private ScoreImpl score;

    public SimpleDecorator(ScoreImpl score) {
        this.score = score;
    }

    public void report(){
        System.out.println("我其实分数挺高");
        score.report();
    }

    public void sign(){
        score.sign();
    }
}
