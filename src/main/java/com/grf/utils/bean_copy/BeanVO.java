package com.grf.utils.bean_copy;

import java.util.List;

/**
 * @ClassName beanDO
 * @Description TODO
 * @Author ceaome
 * @Date 2020/9/9
 **/
public class BeanVO {
    @CopyFieldAlia("personId")
    private String entityId;
    private Integer personType;
    private String name;
    private List<String> girlFriends;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
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

    @Override
    public String toString() {
        return "BeanVO{" +
                "entityId='" + entityId + '\'' +
                ", personType=" + personType +
                ", name='" + name + '\'' +
                ", girlFriends=" + girlFriends +
                '}';
    }
}
