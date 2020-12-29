package com.study.multithread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class InterruptDemo {
    private  static  int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (Thread.currentThread().isInterrupted()) {//判断中断标识
                i++;
                System.out.println("当前序号" + i);
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();  // 修改interrupt 属性true


    }
}
