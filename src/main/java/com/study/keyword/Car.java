package com.study.keyword;

public class Car {

    public  static  void  print(){
        System.out.println("我就想打印一行代码");
    }

    public Car() {
        System.out.println("我是车，我能跑");
    }

    public Car(String  name){
        System.out.println("我是"+ name +"车，我能跑");
    }

    public static void run(){
        System.out.println("我正在跑 。。。");
    }


    static {
        System.out.println("我是父类车子的默认属性，我觉得我会被先初始化");
    }
}
