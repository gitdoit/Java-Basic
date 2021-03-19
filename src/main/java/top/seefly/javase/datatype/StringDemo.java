package top.seefly.javase.datatype;

import org.junit.Test;

/**
 * 为什么字符串是不可变的？ 字符串不可变可以带来很多好处，和避免很多麻烦。例如如果字符串不可变的话 那么我们只需要对一个字符串对象计算一次hash值就行了，而且我们可以将字符串放在字符串常量池中，这样可以
 * 在有很多相同字符串的情况下从字符串常量池中取，减少内存开销。并且如果不可变的话，它是天然线程安全的。 同时，我们在实际开发中会经常使用字符串进行传参，这个时候如果可变的话，会造成很多麻烦。 字符串的存储方式？
 * 在java9之前，字符串都是使用char数组来存储的，从java9开始使用byte数组来存储，这样做的目的是减少内存开销。 因为我们知道一个char占用两个字节，而并不是所有的字符都需要两个字节表示，那么我们可以使用基本的byte来替换。
 * 什么字符串常量池？有什么作用？ 可以在编译期间确定的字符串字面量会放到字符串常量池中，这样可以减少内存开销。同时如果对字符串对象调用intern方法 的话，如果字符串常量池中没有这个字符串的话会在字符串常量池中放入这个字符串，并返回它的引用。
 * new String("123")会创建几个对象？ 如果在字符串常量池中没有"123"这个字符串的话会创建两个，有则之创建一个。
 *
 * @author liujianxin
 * @date 2021/3/15 19:55
 */
public class StringDemo {
    
    @Test
    public void testString() {
        Object acc = null;
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = c.intern();
        
        System.out.println(c == d);
    }
    
    @Test
    public void testHash() {
        
        Object a = new Object();
        System.out.println(a.hashCode());
    }
}
