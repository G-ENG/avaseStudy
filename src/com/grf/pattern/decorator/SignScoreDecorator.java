package com.grf.pattern.decorator;

public class SignScoreDecorator extends ScoreDecorator {
    public SignScoreDecorator(Score score) {
        super(score);
    }

    @Override
    public void sign() {
        System.out.println("求求你给我签名吧");
        super.sign();
    }
}
