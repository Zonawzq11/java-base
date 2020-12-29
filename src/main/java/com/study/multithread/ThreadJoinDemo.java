package com.study.multithread;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class ThreadJoinDemo {
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            x = 1;
            y = 2;
        });
        Thread t2 = new Thread(()->{
            x = y + 2;
        });
        t1.start();
        t1.join();// t1 保持对 t2 的可见性（保证 t1  一定在 t2  之前执行 ）
        t2.start();
        Thread.sleep(1000);
        System.out.println(x);
    }
}
