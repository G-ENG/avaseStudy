package com.grf.pattern.mediator;

import org.junit.Test;

/**
 *
 * 中介者模式，可以管理一组 colleague ,负责他们之间的通信。
 *
 * 应用：多数据源数据同步
 *
 *
 * @author GRF
 * @version 1.0.0
 * @since 2021/2/2
 */
public class Main {

    @Test
    public void test(){
        DataCenterMediator dataCenterMediator = new DataCenterMediator();
        MysqlColleagueImpl mysqlColleague = new MysqlColleagueImpl();
        PGColleagueImpl pgColleague = new PGColleagueImpl();
        dataCenterMediator.register(mysqlColleague);
        dataCenterMediator.register(pgColleague);

        mysqlColleague.send();
    }
}
