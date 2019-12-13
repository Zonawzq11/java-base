package com.study.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectUtil {
    private AspectUtil(){}

    public static String getClassAddMethodName(ProceedingJoinPoint proPoint) {
        return getClassName(proPoint) + "." + getMethodName(proPoint);
    }

    public static String getClassName(ProceedingJoinPoint proPoint) {
        return proPoint.getTarget().getClass().getName();
    }

    public static String getMethodName(ProceedingJoinPoint proPoint) {
        return proPoint.getSignature().getName();
    }
}
