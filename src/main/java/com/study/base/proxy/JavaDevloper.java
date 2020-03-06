package com.study.base.proxy;

/**
 * https://www.jianshu.com/p/95970b089360
 * 
 */
public class JavaDevloper  implements  Developer{
    private String name;

    public JavaDevloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        System.out.println(this.name+"is coding java");
    }

    @Override
    public void debug() {
        System.out.println(this.name+"is debug java");
    }
}
