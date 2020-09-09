package com.grf.utils.stream;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {


        String s="1,3,4,5";
        /**
         * 生成 stream 对象 :
         * Array.stream()
         * Collection集合下也有.stream
         * 也可以使用 Stream.of Stream.generate
         * 对于 intStream longStream DoubleStream 有 range
         */
        Arrays.stream(s.split(",")).collect(Collectors.toList()).forEach(System.out::println);

        ArrayList<String> collect = Arrays.stream(s.split(",")).collect(Collectors.toCollection(ArrayList::new));
        collect.stream().forEach(System.out::println);

        //使用 generate 生成无限流，需要设置limit
        Stream<Double> mathRandomStream = Stream.generate(Math::random).limit(20);
        //使用 range
        LongStream range = LongStream.range(1, 10);

        /**
         * Stream 下的方法
         *  终端操作：toArray foreach collect anyMatch noMatch
         *  boxed 可为 int 流、long 流提供 Collectors
         *  distinct() 去重
         *  filter 接收一个和Predicate函数对应Lambda表达式,过滤元素
         *  mapToInt mapToLong mapToDouble 对每个元素映射返回对应的流
         */
        IntStream.of(1,2,2,3,4,5,6,7,8,9).boxed().distinct().filter(i->i<=5).collect(Collectors.toList()).forEach(System.out::println);

        //sorted 默认升序
        Object[] objects = mathRandomStream.sorted().toArray();

        mathRandomStream.sorted(Comparator.comparing(Double::longValue).reversed().thenComparing((o1,o2)->{
            if (o1<0.8){return 1;}else {return (int)(o1.doubleValue()-o2.doubleValue());}
        }));

    }}
