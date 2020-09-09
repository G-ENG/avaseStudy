package com.grf.utils.compartor;

import java.util.*;

/**
 * java.util.comparator 的用法示例
 */
public class ComparatorDemo {
    public static void main(String[] args) {

        //naturalOrder 与 reverseOrder
        List<Integer> data = Arrays.asList(1, null, 9, 7, 5, 8);
        data.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        data.sort(Comparator.nullsFirst(Comparator.reverseOrder()));
        data.forEach(System.out::print);
        System.out.println();
        //获取studentList
        List<StudentBean> studentBeansList = getStudentBeansList();
        //用对象的属性排序,并过滤 null
        //转化为流对象后，原本的 studentBeansList 并未改动
        studentBeansList.stream().filter(Objects::nonNull).sorted(Comparator.comparing(StudentBean::getAge));
        studentBeansList.forEach(System.out::print);
        System.out.println();
        //将null 放在最后
        studentBeansList.sort(Comparator.nullsLast(Comparator.comparing(StudentBean::getAge)));
        studentBeansList.forEach(System.out::print);


    }

    /*
        生成studentBean List数据
     */
    private static List<StudentBean> getStudentBeansList(){
        LinkedList<StudentBean> studentBeans = new LinkedList<>();
        studentBeans.add(new StudentBean("gjf",13, StudentBean.Sex.MAN));
        studentBeans.add(new StudentBean("grf",21, StudentBean.Sex.MAN));
        studentBeans.add(new StudentBean("lsf",17, StudentBean.Sex.MAN));
        studentBeans.add(null);
        return studentBeans;
    }

}
