package com.study.keyword;

public class Bike extends Car {
    public Bike() {
        System.out.println("我是自行车，我跑的不是很快");
    }

    public Bike(String name) {
        System.out.println("我是"+name+"，我跑的不是很快");
    }

    public static void  run(){
        System.out.println("我是自行车，我正在跑");
    }

    public static void main(String[] args) {
        //1.期待结果,先输出先初始化父类狗做方法，子类构造方法，子类run() 方法
        Bike bike = new Bike();
        System.out.println("--------------");
        Bike bike1 = new Bike("改自行车");
        bike1.run();
    }
}
