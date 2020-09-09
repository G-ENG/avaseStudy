package com.grf.pattern.decorator;


//创建了一个抽象类，聚合Score，针对report方法装饰，简单一点可以不用写抽象类
public abstract class ScoreDecorator implements Score {
    private Score score;

    public ScoreDecorator(Score score) {
        this.score = score;
    }

    public void report(){
        this.score.report();
    }

    public void sign(){
        this.score.sign();
    }
}
