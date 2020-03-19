package top.seefly.javase.old2017.classdemo;

import java.lang.reflect.Array;

/*
 * java.lang.reflect.Array
 * 可以通过动态的方式创建数组
 *
 */
public class ReflectArrayDemo {

    public static void main(String[] args) {
        //创建一个String类型的长度为10的数组
        Object arr = Array.newInstance(String.class, 10);
        Array.set(arr, 4, "刘建鑫");
        Array.set(arr, 6, "liujianxin");
        Object str = Array.get(arr, 4);
        Object str1 = Array.get(arr, 6);
        System.out.println(str + "" + str1);
    }

}
