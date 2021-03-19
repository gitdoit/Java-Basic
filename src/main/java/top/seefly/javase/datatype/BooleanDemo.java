package top.seefly.javase.datatype;

import org.junit.Test;

/**
 * 布尔类型的缓存池只有两个true false基本类型 基本类型按道理说是占用一个bit位，但是Java里面最小的单位就是byte1
 *
 * @author liujianxin
 * @date 2021/3/15 17:26
 */
public class BooleanDemo {
    
    @Test
    public void test() {
        System.out.println(Boolean.valueOf(true) == true);
        ;
    }
}
