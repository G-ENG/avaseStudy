package com.grf.pattern.Factory;

import org.junit.Test;

/**
 * 抽象工厂是用工厂的方式生成生产产品的工厂，对同一个接口下的产品，可能按照不同要求有不同的生产工厂，可以通过工厂的方式获取该工厂
 */
public class AbstractFactoryDemo {
    //使用接口组织enum，
    interface ProductEnum {
    }
    enum ATypeProduct implements ProductEnum {
        A_TYPE_PRODUCT_1, A_TYPE_PRODUCT_2
    }
    enum BTypeProduct implements ProductEnum {
        B_TYPE_PRODUCT_1, B_TYPE_PRODUCT_2
    }

    //产品接口
    interface Product {
        void getType();
    }
    //存在的几种产品
    class ATypeProduct1 implements Product {
        @Override
        public void getType() {
            System.out.println("A");
        }
    }
    class ATypeProduct2 implements Product {
        @Override
        public void getType() {
            System.out.println("A");
        }
    }
    class BTypeProduct1 implements Product {
        @Override
        public void getType() {
            System.out.println("B");
        }
    }
    class BTypeProduct2 implements Product {
        @Override
        public void getType() {
            System.out.println("B");
        }
    }

    //工厂接口
    interface Factory {
        //使用enum作为参数
        Product newProduct(Enum<? extends ProductEnum> e) throws Exception;
    }
    class ATypeFactory implements Factory {
        @Override
        public Product newProduct(Enum<? extends ProductEnum> e) throws Exception {
            if (ATypeProduct.A_TYPE_PRODUCT_1.equals(e)) {
                return new ATypeProduct1();
            } else if (ATypeProduct.A_TYPE_PRODUCT_2.equals(e)) {
                return new ATypeProduct2();
            }
            throw new Exception("接收的类型错误");
        }
    }
    class BTypeFactory implements Factory {
        @Override
        public Product newProduct(Enum<? extends ProductEnum> e) throws Exception {
            if (BTypeProduct.B_TYPE_PRODUCT_1.equals(e)) {
                return new ATypeProduct1();
            } else if (BTypeProduct.B_TYPE_PRODUCT_2.equals(e)) {
                return new ATypeProduct2();
            }
            throw new Exception("接收的类型错误");
        }
    }

    //创建工厂的工厂，通过系列A、B创建两种生产线
    class getFactoryByType {
        Factory getFactory(String s) throws Exception {
            if ("A".equals(s)) {
                return new ATypeFactory();
            } else if ("B".equalsIgnoreCase(s)) {
                return new BTypeFactory();
            }
            throw new Exception("输入类型错误");
        }
    }


    @Test
    public void test() throws Exception {
        Factory a = new getFactoryByType().getFactory("A");
        System.out.println(a.newProduct(ATypeProduct.A_TYPE_PRODUCT_1).getClass().getName());
        a.newProduct(ATypeProduct.A_TYPE_PRODUCT_2).getType();
        Factory b = new getFactoryByType().getFactory("B");
        System.out.println(b.newProduct(BTypeProduct.B_TYPE_PRODUCT_2).getClass().getName());
        try {
            //错误的使用 B 工厂创建 A 产品
            b.newProduct(ATypeProduct.A_TYPE_PRODUCT_2).getType();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
