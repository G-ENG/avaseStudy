package com.grf.Time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import static org.junit.Assert.*;

import java.time.*;

/**
 * LocalDateDemo
 *
 * @Author GenG
 * @Date 2020/11/13
 **/
public class LocalDateDemo {
    private static final Logger LOG = LoggerFactory.getLogger(LocalDateDemo.class);


    @Test
    public void  test1(){
        long now = LocalDate.now(Clock.systemDefaultZone()).atStartOfDay().toEpochSecond(OffsetDateTime.now().getOffset());
        long now2= LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toLocalDate().atStartOfDay().toEpochSecond(OffsetDateTime.now().getOffset());
        long now3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toLocalDate().atStartOfDay().toEpochSecond(OffsetDateTime.now().getOffset());
        LOG.info("{} {} {}", new long[]{now, now2, now3});
        System.out.println(now+"\n"+now2+"\n"+now3);
        assertEquals(now,now2);
        assertEquals(now,now3);
    }
}
