package com.grf.pattern.mediator;

/**
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/2
 */
public class PGColleagueImpl extends Colleague {
    @Override
    void send() {
        this.mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.println("PGColleagueImpl has received the message of data-change and will sync");
    }
}
