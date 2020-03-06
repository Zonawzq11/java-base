package com.study.base.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
    private final static String TAG = "peter.log.ReflectClass";
    //创建反射对象
    public  static  void reflectNewInstance() {
        try {
            Class<?> clazzBook = Class.forName("com.study.base.reflect.Book");
            Book objectBook = (Book) clazzBook.newInstance();
            objectBook.setAuthor("liushuwang");
            objectBook.setName("Android进阶之光");
            System.out.println(TAG + "reflectNewInstance book = " + objectBook.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        // 反射私有的构造方法
        public static void reflectPrivateConstructor() {
            try {
                Class<?> classBook = Class.forName("com.study.base.reflect.Book");
                Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
                declaredConstructorBook.setAccessible(true);
                Object objectBook = declaredConstructorBook.newInstance("Android开发艺术探索","任玉刚");
                Book book = (Book) objectBook;
                System.out.println(TAG+"reflectPrivateConstructor book = " + book.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook =  Class.forName("com.study.base.reflect.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println(TAG+"reflectPrivateField tag = " + tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.study.base.reflect.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod",int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook,0);
            System.out.println(TAG+"reflectPrivateField tag = " + string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // 创建对象
            ReflectDemo.reflectNewInstance();

            // 反射私有的构造方法
            ReflectDemo.reflectPrivateConstructor();

            // 反射私有属性
            ReflectDemo.reflectPrivateField();

            // 反射私有方法
            ReflectDemo.reflectPrivateMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
