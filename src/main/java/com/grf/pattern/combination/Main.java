package com.grf.pattern.combination;

/*
结构为 A
    B   C
  D     E F
 */
public class Main {
    public static void main(String[] args) {

        //创建对象
        Composite rootComposite = new Composite("A", "root**");
        Composite composite1 = new Composite("B", "composite1**");
        Composite composite2 = new Composite("C", "composite2**");
        Leaf leaf1 = new Leaf("D", "leaf1**");
        Leaf leaf2 = new Leaf("E", "leaf2**");
        Leaf leaf3 = new Leaf("F", "leaf3**");


        //搭建结构
        rootComposite.addChildNode(composite1);
        rootComposite.addChildNode(composite2);
        composite1.addChildNode(leaf1);
        composite2.addChildNode(leaf2);
        composite2.addChildNode(leaf3);

        //操作
        System.out.println(getTreeInfoTest(rootComposite));
        System.out.println("leaf2 的父节点："+leaf2.getParent().operation());
        System.out.println("composite1 的父节点："+composite1.getParent().operation());
    }


    //遍历每个节点执行 operate
    private static String getTreeInfoTest(Component component) {
        StringBuilder result = new StringBuilder();
        if (component instanceof Leaf) {
            return component.operation();
        } else if (component instanceof Composite) {
            //如果是树节点，继续遍历
            Composite c = (Composite) component;
            for (Component each :
                    c.getChildNodeList()) {
                result.append(c.operation()).append(getTreeInfoTest(each));
            }
        }
        return result.toString();
    }
}
