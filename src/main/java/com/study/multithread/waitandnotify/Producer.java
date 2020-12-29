package com.study.multithread.waitandnotify;

import lombok.SneakyThrows;

import java.util.Queue;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class Producer implements  Runnable{
    private Queue<String >  bags;
    private int  size;

    public Producer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }


    @Override
    public void run() {
        int i=0;
        while(true){
            i++;
            synchronized (bags){
                while(bags.size()==size){
                    System.out.println("bags已经满了");
                    //TODO? 阻塞？
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者-生产:bag"+i);
                bags.add("bag"+i);
                //TODO   唤醒处于阻塞状态下的消费者
                bags.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
