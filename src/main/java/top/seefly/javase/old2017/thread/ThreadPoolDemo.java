package top.seefly.javase.old2017.thread;

import java.util.concurrent.*;

/*
 * java通过Executors提供四种线程池
 * newCacheThreadPool创建一个可缓存的线程池，容量可灵活更改，若容量不够处理需要，则新开辟线程。若大于处理需要则回收。
 * newFixedThreadPool创建一个容量固定的线程池，可以限制线程最大并发量，超出的线程在队列中等待。
 * newScheduledThreadPool 创建一个容量固定的线程池，支持定时以及周期处理任务
 * newSingleThreadExecutors创建容量为1的线程池，使用这唯一的线程处理任务，保证所有任务按指定顺序执行任务(FIFO,LIFO,优先级)
 *http://cuisuqiang.iteye.com/blog/2019372
 * */
public class ThreadPoolDemo {
    
    public static void main(String[] args) {
        //ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService FixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {//循环创建线程，被FixedThreadPool包装。线程池容量为3，所以同时并发的线程最多只有三个，其余的等待
            //cachedThreadPool.execute(new CacheThread());
            FixedThreadPool.execute(new CacheThread());
            //if(i == 7)
            //FixedThreadPool.shutdown();//此方法会使线程停止接受新任务(若继续添加则会报错)，且完成正在执行与等待列队中的任务。
            ExecutorService CachePool = Executors.newCachedThreadPool();//shutdownNow会使正在执行的线程处于中断状态，返回并清除等待列队中的线程
            CachePool.execute(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    
                }
            });
        }
        
    }
}

class CacheThread implements Runnable {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
