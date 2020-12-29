package com.study.multithread.waitandnotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        int size=10;
        Producer producer=new Producer(queue,size);
        Consumer consumer=new Consumer(queue,size);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}
