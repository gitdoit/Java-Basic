package top.seefly.javase.datatype;

import org.junit.Test;

/**
 * char占用两个字节，最大只能表示65535个字符 unicode字符集最大需要4byte来表示一个字符，那么超出2byte的字符怎么表示？ 答案是：基本类型char没法表示超出2byte的字符，超出部分取余，所以部分中文没法用char来表示
 * 但这并不代表着也不能用string来表示 https://my.oschina.net/u/914655/blog/318664
 *
 * @author liujianxin
 * @date 2021/3/15 17:33
 */
public class CharDemo {
    
    @Test
    public void test() {
        Character a = 'a';
        char b = 'a';
        // 包装类型和基本类型比较会自动拆箱，比较基本值
        System.out.println(a == b);
    }
    
    @Test
    public void testCom() {
        Character a = 'a';
        Character b = 'a';
        System.out.println(a == b);
        
    }
    
    
    /**
     * 在java中使用utf16表示一个字符，这意味着 一个字符只占两个字节，超出范围的会使用65535取模，使用 他的余数表示这个字符
     */
    @Test
    public void testChinese() {
        // 䧊1
        System.out.println((char) (84426 - 65536));
        // 䧊
        System.out.println((char) (84426 + 65536));
    }
    
    
}
