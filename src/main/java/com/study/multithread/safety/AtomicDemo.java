package com.study.multithread.safety;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class AtomicDemo {
    public static int count = 0;

    public static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println(count);
        count++;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::incr).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:" + count);
    }
}
