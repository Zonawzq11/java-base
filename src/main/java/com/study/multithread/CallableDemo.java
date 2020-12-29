package com.study.multithread;

import java.util.concurrent.*;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "志强";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new CallableDemo());
        System.out.println(future.get());
    }
}
