package com.study.java8;

import java.util.Optional;

/**
 * Optional 实例
 */
public class OptionalExample {
    public static void main(String[] args) {
        OptionalExample optionalExample = new OptionalExample();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        //  Optional.ofNullable - 允许传递为null 参数
        Optional<Integer> value11 = Optional.ofNullable(value1);
        //Optional.of 如果传递的参数是null,抛出异常NullPointerException
        Optional<Integer> value21 = Optional.of(value2);
        System.out.println(optionalExample.sum(value11,value21));
    }

    private Integer sum(Optional<Integer> value11, Optional<Integer> value21) {
        //Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在" + value11.isPresent());
        System.out.println("第二个参数值存在：" + value21.isPresent());

        //Optional.orElse -如果值存在，返回它，否则返回默认值
        Integer var1 = value11.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer var2 = value21.get();
        return  var1 + var2;
    }
}
