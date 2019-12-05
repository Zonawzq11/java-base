package com.study.collections.hashmap;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap 源码实现
 *
 * @param <K>
 * @param <V>
 */
public class HashMapCode<K, V> extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable, Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 初始化容量（the power of two）
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * 加载因子（the power of two）
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /*
     *  设置初始化容量是2 的指数次幂，指导思想是充分散列，减少碰撞
     *   当HashMap 的数组长度达到一个临界长度就会触发扩容,把所有元素rehash再放回容器中，这是一个非常耗时的操作（决定权= 加载因子 * 初始化容量 ）
     */


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
