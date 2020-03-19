package top.seefly.javase.old2017.thread;

/*
 * 该类演示了对于同一个同步代码块，如果多个线程使用不同的锁，那么多个线程会并发执行这个同步代码块
 *
 * */
public class SynchronizedDemo2 {
    public static void main(String[] args) {
        runnable p = new runnable();
        Thread t1 = new Thread(p, "t1");
        Thread t2 = new Thread(p, "t2");
        //try{Thread.sleep(50);}catch(Exception ex){}
        t1.start();
        t2.start();

    }

}

class runnable implements Runnable {
    private int count = 100;

    public void run() {
        Object a = new Object();//每一个线程进来都会新建一个对象，每个线程的锁并不一样
        synchronized (a) {
            while (count > 0) {
                try {
                    Thread.sleep(10);
                } catch (Exception ex) {
                }
                System.out.println(Thread.currentThread().getName() + "   ******   " + count--);
            }
        }
    }
}

