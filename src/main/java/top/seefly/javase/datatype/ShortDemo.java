package top.seefly.javase.datatype;

import org.junit.Test;

/**
 * short类型 2字节，包装类型为Short，有常量池缓存，范围也是-128~127
 *
 * @author liujianxin
 * @date 2021/3/15 17:17
 */
public class ShortDemo {
    
    @Test
    public void testBox() {
        Short a = 127;
        Short b = 127;
        System.out.println(a == b);
        
        Short c = 128;
        Short d = 128;
        
        System.out.println(c == d);
    }
    
}
