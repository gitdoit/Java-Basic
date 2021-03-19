package top.seefly.javase.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 基于TreeMap实现，元素唯一且有序，这个有序不是插入顺序，而是元素自然排序的顺序。
 *
 * @author liujianxin
 * @date 2021/3/16 11:06
 */
public class TreeSetDemo {
    
    @Test
    public void test() {
        TreeSet<Object> set = new TreeSet<>();
        // 报错，必须实现Comparable接口或者传入比较器
        set.add(new Object());
        set.add(new Object());
        System.out.println(set);
    }
}
