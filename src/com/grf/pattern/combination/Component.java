package com.grf.pattern.combination;
/*
适用于树结构，抽象类定义每个节点共有的属性、方法
不选用接口的原因是，接口的属性时public static final的，也没有默认的构造方法
*/
abstract class Component {
    private String propertyA = null;
    private String PropertyB = null;
    private Component parent=null;

    String operation() {
        return propertyA + PropertyB;
    }

    public Component(String propertyA, String propertyB) {
        this.propertyA = propertyA;
        this.PropertyB = propertyB;
    }

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }
}
