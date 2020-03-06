package com.study.java8;

import java.util.ArrayList;

public class MethodQuote {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
