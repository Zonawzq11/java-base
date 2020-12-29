package com.study.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class ThreadStatusDemo {
    public static void main(String[] args) {
        //TIME-WAITING
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Time-waiting-demo").start();
        //WAITING
        new Thread(() -> {
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "waiting").start();
        new Thread(new BlockedDemo(),"Blocked01").start();
        new Thread(new BlockedDemo(),"Blocked02").start();
    }

    static class BlockedDemo extends Thread {
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
