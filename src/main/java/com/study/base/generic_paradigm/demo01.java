package com.study.base.generic_paradigm;

/**
 * @Description: 枚举方法
 * @Authorzhiqiangwang
 */
public class demo01 {
    public static void main(String[] args) {
        System.out.println(demo01.getT("123"));

    }
    private static   <T>T getT(T t){
        return  t;
    }
}
