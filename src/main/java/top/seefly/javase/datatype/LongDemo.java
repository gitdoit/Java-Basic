package top.seefly.javase.datatype;

import org.junit.Test;
import sun.rmi.runtime.Log;

/**
 * long类型由8字节表示，和int一样也有包装类型缓存池范围相同；
 *
 * @author liujianxin
 * @date 2021/3/15 17:23
 */

public class LongDemo {
    
    @Test
    public void test() {
        Long a = 127l;
        Long b = 127l;
        
        int c = 127;
        
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
