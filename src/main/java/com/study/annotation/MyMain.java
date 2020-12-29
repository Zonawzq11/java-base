package com.study.annotation;

import java.lang.reflect.Method;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
@MyAnnotation(className = "com.study.annotation.Operation",methodName = "outXXX")
public class MyMain {
    public static void main(String[] args) throws Exception {
        Class<MyMain> myMainClass = MyMain.class;
        MyAnnotation annotation = myMainClass.getAnnotation(MyAnnotation.class);
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className + "_" + methodName);
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        declaredMethod.invoke(o);
    }

}
