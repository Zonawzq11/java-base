package com.study.base.generic_paradigm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 泛型测试
 * @Author zhiqiangwang
 */
public class demo {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("adc");
        Class<? extends List> listClass = list.getClass();
        Method add = listClass.getDeclaredMethod("add", Object.class);
        add.invoke(list,new Object());
        System.out.println(list);
    }
}
