package com.grf.pattern.mediator;

/**
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/2
 */
public class MysqlColleagueImpl extends Colleague {
    @Override
    void send() {
        System.out.println("data changed from mysql");
        this.mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.println("MysqlColleagueImpl has received the message of data-change and will sync");
    }
}
