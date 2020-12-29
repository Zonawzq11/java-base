package com.study.multithread;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(runnableDemo).start();
    }
}
