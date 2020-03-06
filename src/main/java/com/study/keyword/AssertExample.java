package com.study.keyword;

/**
 * assert 关键字  实例
 */
public class AssertExample {
    public static void main(String[] args) {
        System.out.println("123");
        int a= 0;
        int b= 1;
        assert a == b;
        assert a == b : "执行失败";
        System.out.println("1234");
    }
}
