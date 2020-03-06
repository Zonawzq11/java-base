package com.study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式编程
 */
public class FunctionFormula {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据");
        // 传递参数 n
        // Predicate 接受一个输入参数，返回一个boolean结果
        eval(list,n->true);
        System.out.println("输出所有的偶数");
        eval(list,n->n%2 == 0);
        //
        System.out.println("输出大于3的所有数字");
        eval(list,n -> n > 3);

    }
    public static void eval(List<Integer>list, Predicate<Integer> predicate){
        for (Integer n :list){
            if (predicate.test(n)){
                System.out.println(n + " ");
            }
        }
    }
}
