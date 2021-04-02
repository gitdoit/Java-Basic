package top.seefly.javase.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * gc会触发stw，暂停用户线程
 * @author liujianxin
 * @date 2021/3/30 19:54
 */
public class ShowStopTheWorld {
    
    
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            List<byte[]> list = new ArrayList<>();
            while (true){
                for (int i = 0; i < 1000; i++) {
                    list.add(new byte[1024]);
                }
                if(list.size() > 10000){
                    list.clear();
                    System.gc();
                }
            }
        },"t1");
        
        Thread t2 = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (true){
                System.out.println((System.currentTimeMillis() - start) / 1000f );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");
        
        t1.start();
        t2.start();
    }
}
