package com.grf.pattern.decorator;

import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        Score score = new ScoreImpl();
        Score hIghScoreDecorator = new HIghScoreDecorator(score);
        Score signScoreDecorator = new SignScoreDecorator(hIghScoreDecorator);
        score.report();
        hIghScoreDecorator.report();
        signScoreDecorator.report();
        hIghScoreDecorator.sign();
        signScoreDecorator.sign();
    }
}
