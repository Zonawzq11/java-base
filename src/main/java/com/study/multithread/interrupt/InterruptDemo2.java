package com.study.multithread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =  new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Before:" + Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    System.out.println("After:" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
