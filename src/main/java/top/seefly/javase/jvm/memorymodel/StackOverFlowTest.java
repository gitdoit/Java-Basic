package top.seefly.javase.jvm.memorymodel;

import org.junit.Test;

/**
 * @author liujianxin
 * @date 2021/3/23 16:16
 */
public class StackOverFlowTest {
    private static int count = 0;
    
    @Test
    public void testOOM(){
    
    }
    
    /**
     * linux系统默认的栈大小是1m,当循环24882次的时候就会爆掉;StackOverFlowError
     *
     * 通过调整虚拟机参数 -Xss256k 设置新的栈大小
     */
    public static void main(String[] args) {
        try {
            loopCall();
        }catch (Throwable ex){
            System.out.println(count);
        }
    }
    
    public static void loopCall(){
        count++;
        loopCall();
    }
}
