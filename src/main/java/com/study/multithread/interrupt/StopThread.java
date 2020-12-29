package com.study.multithread.interrupt;

import ch.qos.logback.core.util.TimeUtil;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class StopThread {
    private  static volatile   boolean  flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!flag){
                System.out.println("线程正在运行 。。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("线程结束");
        flag = true;
    }
}
