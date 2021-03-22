package top.seefly.javase.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liujianxin
 * @date 2021/3/19 11:32
 */
public class MyLock implements Lock {
    private MySync sync= new MySync();
    
    class MySync extends AbstractQueuedSynchronizer {
        
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        
        @Override
        protected int tryAcquireShared(int arg) {
            
            return super.tryAcquireShared(arg);
        }
        
        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }
    
        /**
         * 是否持有独占锁
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }
    
    
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        
        new Thread(() -> {
            lock.lock();
            System.out.println("t1 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t1 unlock");
            }
            
        },"t1").start();
        new Thread(() -> {
            lock.lock();
            System.out.println("t2 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t2 unlock");
            }
        
        },"t2").start();
    }
    
    @Override
    public void lock() {
        sync.acquire(1);
    }
    
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }
    
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }
    
    @Override
    public void unlock() {
        sync.release(1);
    }
    
    @Override
    public Condition newCondition() {
        return null;
    }
}
