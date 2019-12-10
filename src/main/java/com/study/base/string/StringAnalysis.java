package com.study.base.string;


import javax.validation.constraints.NotBlank;

public class StringAnalysis {
   /* public static void main(String[] args) {
        // StringBuilder stringBuilder = new StringBuilder();
        // StringBuffer stringBuffer = new StringBuffer();
        long time1 = System.currentTimeMillis();
        String test1 = "wangzhiqiang" + "_hello" + "_world";
        for (int i = 0; i < 10000000; i++) {
            test1 =""+ i ;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("执行任务1时间:"+(time2 - time1));
        long time3 = System.currentTimeMillis();
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < 10000000 ; i++) {
            stringBuilder1.append(i);
        }
        long time4 = System.currentTimeMillis();
        System.out.println("执行任务2时间:"+(time4 - time3));
    }*/
    private static void getParam(@NotBlank String param){
        System.out.println("我是参数"+param);
    }

    public static void main(String[] args) {
         new Exception();
    }
}
