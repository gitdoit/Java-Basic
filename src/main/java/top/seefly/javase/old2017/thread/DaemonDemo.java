package top.seefly.javase.old2017.thread;

/*
 * 后台线程又称为守护线程
 * 该线程有一个特点那就是，在主线程死亡后那么它也会死亡。
 * 例如有两个线程t1,t2
 * 在t1线程中new出t2线程，并在调用start方法前
 * 设置：t2.setDaemon(true) 然后t2.start()
 * 此时t2线程就被设置为t1线程的守护线程，在t1死亡后t2也会死亡
 * 注意不要在线程为就绪态后设置Daemon否则会报IllegalThreadStateException
 *
 * */
public class DaemonDemo implements Runnable {
    
    public static void main(String[] args) {
        DaemonDemo r = new DaemonDemo();
        Thread t = new Thread(r, "t1");
        t.start();
    }
    
    @Override
    public void run() {//由前台线程创建的线程都为前台线程，反之都为后台线程
        Thread t2 = new Thread(new Runnable() {//在t1线程内创t2线程
            @Override
            public void run() {
                for (int t2 = 0; t2 < 1000; t2++) {
                    System.out.println(Thread.currentThread().getName() + ":t2=" + t2);//设置循环1000次，比t1线程多
                }
            }
        }, "t2");
        t2.setDaemon(true);//设置为后台线程
        t2.start();//启动
        for (int t1 = 0; t1 < 100; t1++) {
            System.out.println(Thread.currentThread().getName() + "t1:" + t1);//t1线程循环100次
        }
    }
    
}

