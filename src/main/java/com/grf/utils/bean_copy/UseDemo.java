package com.grf.utils.bean_copy;

import org.junit.Test;

import java.util.Collections;

/**
 * @ClassName UseDemo
 * @Author ceaome
 * @Date 2020/9/9
 **/
public class UseDemo {
    @Test
    public void testMyBeanCopyUtil(){
        BeanDO beanDO = new BeanDO();
        beanDO.setName("耿瑞风");
        beanDO.setPersonId("123");
        beanDO.setPersonType(1);
        beanDO.setGirlFriends(Collections.singletonList("吴昕奕"));

        BeanVO beanVO = new BeanVO();
        BeanCopyUtil.copyBean(beanDO,beanVO);
        System.out.println(beanVO);
    }
}
