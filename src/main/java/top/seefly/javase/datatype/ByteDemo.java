package top.seefly.javase.datatype;

import org.junit.Test;

/**
 * byte 一字节(废话)，8bit表示的数据范围是(-128~127) 包装类型把byte能表示的数据全给缓存起来了
 *
 * @author liujianxin
 * @date 2021/3/15 17:19
 */
public class ByteDemo {
    
    @Test
    public void test() {
        Byte a = 127;
        Byte b = 127;
        
        System.out.println(a == b);
        
    }
}
