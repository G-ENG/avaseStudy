package com.grf.Enum;

import org.junit.Test;

/*
  因为无法继承自enum，所以为了给 enum 分类，可以使用接口组织
 */
public class EnumComb{
  interface food{}
  enum Vegetables implements food{
      CABBAGE,TOMATO
  }
  enum Fruit implements food{
      APPLE, BANANA
  }

  @Test
    public void test(){
      food cabbage = Vegetables.CABBAGE;
      food tomato = Vegetables.TOMATO;
      food apple = Fruit.APPLE;
      food banana = Fruit.BANANA;
      System.out.println(cabbage.toString()+tomato+apple+banana);
  }
}
