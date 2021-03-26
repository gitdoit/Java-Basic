package top.seefly.javase.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 如何优雅的停止线程池啊？
 * @author liujianxin
 * @date 2021/3/23 14:31
 */
public class ClosePoolInGoodWay {
    
    
    @Test
    public void testClose() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2)){
            @Override
            protected void terminated() {
                System.out.println("当前线程池状态:"+this.isTerminated());
                System.out.println("当前线程池状态:"+this.isTerminating());
                super.terminated();
            }
        };
    
        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("任务执行完毕！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("主线程等待线程池结束结果："+executor.awaitTermination(3,TimeUnit.SECONDS));
        
    }
    
}
