package top.seefly.javase.thread.pool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liujianxin
 * @date 2021/3/21 18:42
 */
public class ThreadPoolExecutorDemo {
    
    @Test
    public void test() throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,4,100, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        pool.execute(() -> {
                LockSupport.park();
                System.out.println("线程醒了");
            
        });
        
        // pool.shutdown();
        pool.shutdownNow();
        
        
        Thread.sleep(4000);
    
        //ScheduledExecutorService pool1 = Executors.newScheduledThreadPool(4);
    }
    
}
