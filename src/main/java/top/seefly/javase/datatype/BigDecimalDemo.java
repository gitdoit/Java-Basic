package top.seefly.javase.datatype;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 为什么BigDecimal能够准确表示浮点数而不造成精度丢失？
 * <p>
 * 对于浮点数的计算，直接使用float或者double可能会造成精度丢失，导致计算结果不正确
 *
 * @author liujianxin
 * @date 2021/3/16 8:42
 */
public class BigDecimalDemo {
    
    /**
     * 精度丢失问题
     */
    @Test
    public void testNotRight() {
        float a = 1.1f;
        float b = 0.4f;
        float c = 0.7f;
        // 按道理来说 1.1 - 0.4 = 0.7
        // 但是由于计算机底层的二进制原因，没法准确表示0.7而是一个近似的值
        // 所以下面这个为false
        System.out.println(c == (a - b));
    }
    
    /**
     * 在创建BigDecimal的时候需要使用字符串作为构造参数 或者使用BigDecimal.valueOf()来。 如果直接使用浮点数来当作构造函数的参数，那么由于浮点数 没法精确表示部分数值的原因会造成精度丢失
     */
    @Test
    public void testBigDecimal() {
        BigDecimal a = new BigDecimal("1.1");
        BigDecimal b = new BigDecimal("0.4");
        BigDecimal c = new BigDecimal("0.7");
        
        System.out.println((a.subtract(b)).equals(c));
    }
}
