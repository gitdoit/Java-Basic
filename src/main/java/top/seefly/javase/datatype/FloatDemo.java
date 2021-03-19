package top.seefly.javase.datatype;

import org.junit.Test;

/**
 * 浮点类型
 *
 * @author liujianxin
 * @date 2021/3/15 16:52
 */
public class FloatDemo {
    
    
    /**
     * 浮点数的包装类型没有常量池进行缓存 所以下面的自动装箱是两个对象，使用 == 比较的是地址 false
     */
    @Test
    public void test1() {
        Float a = 1.2f;
        Float b = 1.2f;
        System.out.println(a == b);
    }
    
    /**
     * 基本类型比较的是数值，值相等 true
     */
    @Test
    public void test2() {
        float a = 1.2f;
        float b = 1.2f;
        System.out.println(a == b);
    }
    
    /**
     * 下面的表达式中有运算符 会自动拆箱到基本类型然后再进行数值的比较 true
     */
    @Test
    public void test3() {
        Float a = 1.1f;
        Float b = 1.2f;
        Float c = 0.1f;
        
        System.out.println(b == (a + c));
    }
}
