package com.study.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaDynamicProxy {
    public static void main(String[] args) {
        JavaDevloper zhiqiang = new JavaDevloper("zhiqiang");
        Developer zhiqiangProxy = (Developer) Proxy.newProxyInstance(zhiqiang.getClass().getClassLoader(),
                zhiqiang.getClass().getInterfaces(),
                /*((proxy, method, args1) ->{
                    if (method.getName().equals("code")) {
                        System.out.println("zhiqiang is praying for the code");
                        return  method.invoke(zhiqiang,args1);
                    }
                    if (method.getName().equals("debug")){
                        System.out.println("zhiqiang is have no bug,No need to debug");
                        return null;
                    }
                    return null;
                })*/
                (proxy, method, args1) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("zhiqiang is praying for the code");
                        return  method.invoke(zhiqiang, args1);
                    }
                    if (method.getName().equals("debug")){
                        System.out.println("zhiqiang is have no bug,No need to debug");
                        return null;
                    }
                    return null;
                });
        zhiqiangProxy.code();
        zhiqiangProxy.debug();

        System.out.println("动态代理测试------");
        LogHandler logHandler = new LogHandler();
        Developer o =(Developer)logHandler.newProxyInstace(new JavaDevloper("志强"));
        o.code();
    }}