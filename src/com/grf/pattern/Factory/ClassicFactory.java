package com.grf.pattern.Factory;


import org.junit.Test;

public class ClassicFactory {

    enum ProductName {
        Product1, Product2, Product3
    }

    interface Product {
    }

    static class Product1 implements Product {
    }

    static class Product2 implements Product {
    }

    static class Product3 implements Product {
    }

    static class ProductFactory {
        static Product newProductByName(ProductName productName) throws Exception {
            switch (productName) {
                case Product1:
                    return new Product1();
                case Product2:
                    return new Product2();
                case Product3:
                    return new Product3();
            }
            throw new Exception("无法生成对象");
        }
    }

    @Test
    public void test() throws Exception {
        System.out.println(ProductFactory.newProductByName(ProductName.Product1).getClass().getName());
    }
}
