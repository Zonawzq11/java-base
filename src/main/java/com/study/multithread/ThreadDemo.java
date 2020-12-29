package com.study.multithread;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class ThreadDemo extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

}
