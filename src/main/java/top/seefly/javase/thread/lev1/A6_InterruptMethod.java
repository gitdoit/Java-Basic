package top.seefly.javase.thread.lev1;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * 如果线程处于阻塞状态时调用该线程的interrupt方法，会使该线程出现异常，然后结束该线程。
 *
 * 除了LockSupport.park()方法
 * 其他能让线程进入WAIT/TIMED_WAIT状态的方式，被中断时都会抛出中断异常
 * 例如 sleep/wait/join;
 *
 * LockSupport.park 不会抛出中断异常，你对这个线程调用中断后，他会从WAIT状态醒过来继续往后执行。
 * @author 刘建鑫
 */
public class A6_InterruptMethod {
    
    /**
     * t1线程 park前,看看中断状态:false
     * 主线程中检查t1的状态:WAITING
     * t1线程 park后。看看中断状态：true
     */
    @SneakyThrows
    @Test
    public void testLockSupport(){
        Thread t1 = new Thread(() -> {
            System.out.println("t1线程 park前,看看中断状态:"+Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println("t1线程 park后。看看中断状态："+Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        
        Thread.sleep(200);
        System.out.println("主线程中检查t1的状态:"+t1.getState());
        t1.interrupt();
    }
    
    @Test
    public void testJoin() throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(200);
                mainThread.interrupt();
            } catch (InterruptedException e) {
                System.out.println("子线程休眠异常！");
            }
    
        }, "t1");
        t1.start();
        
        try {
            t1.join();
        }catch (Exception ex){
            System.out.println("主线程join后中断异常");
        }
        
    }
    
    
    /**
     * 测试休眠状态下的异常
     * 休眠方法会让线程进入TIMED_WAIT状态
     */
    @SneakyThrows
    @Test
    public void testInterrupt1(){
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                Thread.interrupted();
            }
        },"t1");
        t.start();
        Thread.sleep(200);
        t.interrupt();
        System.out.println("结束！");
    }
    
    /**
     * BLOCK状态下，中断无法打断它的阻塞状态
     */
    @SneakyThrows
    @Test
    public void testBlockInt(){
        Thread t1 = new Thread(() -> {
            synchronized (A6_InterruptMethod.class) {
                System.out.println("子线程拿到了锁！");
            }
        
        }, "t1");
        t1.start();
        synchronized (A6_InterruptMethod.class){
            Thread.sleep(200);
            t1.interrupt();
            System.out.println(t1.getState());
        }
    }
    
    /**
     * 调用wait()方法处于WAIT或者TIMED_WAIT状态时，可能会发生中断异常
     */
    @Test
    public void testWait() throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread t1 = new Thread(() -> {
            synchronized (A6_InterruptMethod.class) {
                System.out.println("子线程拿到了锁！");
                mainThread.interrupt();
            }
        
        }, "t1");
        t1.start();
        
        
        synchronized (A6_InterruptMethod.class){
            Thread.sleep(200);
            try{
                A6_InterruptMethod.class.wait();
                System.out.println("wait 结束");
            }catch (Exception ex){
                System.out.println(ex.getLocalizedMessage());
                System.out.println("主线程wait时发生中断！");
            }
        }
        
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                //延时，防止主线程中的(t.interrupt)在子线程下面语句执行后才执行
                for (int i = 0; i < 1000000; i++) {
                    //do nothing
                }
                //此方法会检测中断状态位，且返回该中断状态，然后将之重置为false
                System.out.println("子线程是否被中断了：" + Thread.interrupted());
                //该方法只返回中断状态，但不会对其做任何操作
                System.out.println("线程将进入休眠，且中断状态为：" + Thread.currentThread().isInterrupted());
                Thread.sleep(1000);
                System.out.println("线程休眠完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        //中断该线程(不是结束该线程)，将中断位置true
        t.interrupt();
        
    }
    
}
