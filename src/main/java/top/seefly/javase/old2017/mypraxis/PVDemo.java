package top.seefly.javase.old2017.mypraxis;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * await()和wait()类似，都是将线程强制转换为阻塞态await等待signal()或者signalAll.将其唤醒进入就绪态。
 * 这两个信号的出现意味着，条件可能满足了，需要重新测试一次，但并不肯定满足执行要求
 * */
public class PVDemo {
    public static void main(String[] args) {
        Computer r = new Computer();
        Thread producer = new Thread(r, "produer");
        Thread consumer = new Thread(r, "consumer");
        producer.start();
        consumer.start();
    }
}

class Computer implements Runnable {
    private int depot = 0;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("produer"))
            while (true) {
                lock.lock();
                try {
                    while (depot >= 1) //循环判断是否满足要求，注意这里不能使用if否则下次被唤醒之后就从await方法中返回了，不加以判断就去执行下面的
                        //当然，因为本程序只有两个线程，该线程被唤醒，肯定是满足执行条件了，那么在更多的线程中有更多的生产者就不会这样了
                        con.await();//不满足，则进入阻塞，释放锁。等待signalAll唤醒，再进行下次检测
                    depot++;
                    con.signalAll();
                    System.out.println("生产了一台电脑,仓库中还剩" + depot + "台电脑");
                    //Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                for (int i = 0; i < 1000; i++) ;//延时，增加该线程未持有锁的时间，使消费者线程抢到锁的概率增大。
                //不至于连续生产致使每次都使仓库填满
            }
        while (true) {
            lock.lock();
            try {
                while (depot == 0)
                    con.await();
                depot--;
                con.signalAll();
                System.out.println("卖了一台电脑,仓库中还剩" + depot + "台电脑");
                //Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            //for(int i = 0; i < 100;i++);
        }
    }
}

