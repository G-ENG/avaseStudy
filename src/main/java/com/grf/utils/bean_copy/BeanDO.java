package com.grf.utils.bean_copy;

import java.util.List;

/**
 * @ClassName beanDO
 * @Description TODO
 * @Author ceaome
 * @Date 2020/9/9
 **/
public class BeanDO {
    String personId;
    Integer personType;
    String name;
    List<String> girlFriends;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGirlFriends() {
        return girlFriends;
    }

    public void setGirlFriends(List<String> girlFriends) {
        this.girlFriends = girlFriends;
    }
}
