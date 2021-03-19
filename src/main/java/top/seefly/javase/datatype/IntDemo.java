package top.seefly.javase.datatype;

/**
 * int 对应的包装类型为Integer，有符号整性，使用4字节存储 Integer有常量池，范围是-128倒127.
 *
 * @author liujianxin
 * @date 2021/3/15 16:35
 */
public class IntDemo {
    
    public static void main(String[] args) {
        // 编译后自动装箱，Integer x = Integer.valueOf(127);
        Integer x = 127;
        Integer y = 127;
        // 虽然会自动装箱，但没有使用到常量缓存池里的数据
        // 其实最终是创建新的对象
        Integer z = 128;
        Integer e = 128;
        
        // 在范围内 true
        System.out.println(x == y);
        // 在范围外 false
        System.out.println(z == e);
    }
}
