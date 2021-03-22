package top.seefly.javase.juc.locks;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阿里面试题 多个线程顺序打印1 2 3 4.... 我觉得可以用条件锁
 *
 * @author liujianxin
 * @date 2021/3/20 18:04
 */
public class ThreadLoopPrintDemo {
    
    class Printer extends Thread {
        
        private Condition last;
        
        private Condition next;
        
        private ReentrantLock lock;
        
        public Printer(Condition last, Condition next, ReentrantLock lock, String name) {
            super(name);
            this.last = last;
            this.next = next;
            this.lock = lock;
        }
        
        @Override
        public void run() {
            System.out.println("1212");
            lock.lock();
            try {
                while (true) {
                    last.await();
                    System.out.println(Thread.currentThread().getName());
                    next.signal();
                }
            } catch (Exception exception) {
                System.out.println("异常了");
            } finally {
                lock.unlock();
            }
        }
    }
    
    @Test
    public void testPrint() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition first = lock.newCondition();
        Condition last = null;
        Condition next = null;
        for (int i = 0; i < 9; i++) {
            Printer p = null;
            if (i == 0) {
                next = lock.newCondition();
                p = new Printer(first, next, lock, "线程" + i);
            } else if (i != 8) {
                last = next;
                next = lock.newCondition();
                p = new Printer(last, next, lock, "线程" + i);
            } else {
                last = next;
                next = first;
                p = new Printer(last, next, lock, "线程" + i);
            }
            p.start();
        }
        
        Thread.sleep(20);
        lock.lock();
        first.signal();
        lock.unlock();
        Thread.sleep(20000);
        
        
    }
    
    
}
