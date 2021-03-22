package top.seefly.javase.thread.pool;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * fork/join一般用来分解计算密集型任务
 * 体现的是一种分治思想，将一个大的任务，分解成很多个小的任务，然后将这些小任务的计算结果进行一个合并
 * 得到一个最终的计算结果。
 *
 *
 * @author liujianxin
 * @date 2021/3/21 20:23
 */
public class ForkJoinPoolDemo {
    
    @Test
    public void testForkJoin(){
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new MyTask(10)));
    
    }
    
    class MyTask extends RecursiveTask<Integer>{
        private int num;
    
        MyTask(int num) {
            this.num = num;
        }
    
        @Override
        protected Integer compute() {
            if(this.num == 1){
                return this.num;
            }
            MyTask t = new MyTask(this.num -1);
            t.fork();
            return this.num + t.join();
        }
    }
    
}
