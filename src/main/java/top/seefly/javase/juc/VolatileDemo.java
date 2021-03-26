package top.seefly.javase.juc;

/**
 * 2018-07-30 10:50笔记
 * Volatile关键字的作用
 * 1. 由于多线程环境先，当同时有多个线程对同一个变量进行操作，那么都是从内存中读取该变量的值，到cpu的高速缓存中。
 *    然后在高速缓存中对此变量副本进行操作，之后才会从新写入到主存中。而什么时候写入主存是不确定的，这就造成了一种现象叫做不可见性。
 *    而volatile关键字则会使这种操作变为可见的，也就说一旦一个线程对一变量进行 了修改，那么会立即写入主存。
 *    同时使其他线程中的变量副本变为失效的， 致使他们从新到主存中读取新的值。所以保证其他线程读取到的都是最新的。
 * 2. volatile关键并不会杜绝丢失更新的现象。
 *    因为volatile关键字只保证当主存中的值被修改了之后才会通知到各个修改本副本。
 *    那么当其中一个线程在修改本地副本的时候，还没有来得及将修改变量更新到主存就是去了cpu资源，然后其他线程对这个变量
 *    进行了修改，那么这个线程修改完成之后，之前的一个线程再从新写入没有来得及写入的数据就会造成丢失更新。
 * 3. volatile关键字值保证各个线程中存储的被volatile关键字修饰的变量的副本和主存当中的一致。
 *    但各个线程修改自己本地变量以及更新到主存并不是一个原子操作。
 *
 * 2021年3月25日
 *  说这个首先要了解java内存模型，java内存模型抽象了计算机底层结构，将内存分为主存和线程自己的工作空间，主存工作效率比较低而工作空间利用cpu高速缓存
 *  所以效率很高。同时jmm规定线程如果要使用主存中的数据的话，不能直接访问首先要读取到自己的工作空间里，更新之后再写回主存。这样一来就会发生共享变量
 *  可见性的问题。而volatile关键字可以保证共享量在多线程之间的可见性，以及防止指令重排序这两个问题。
 *  具体原理是使用内存屏障，例如变量A使用volatile关键字修饰了，它会在对变量A的读操作之前加入读屏障，告诉这个线程读之前需要从主存中更新一下这个A
 *  的值，并在写操作之后加入写屏障，告诉这个线程更新A之后要立即把A以及其他共享变量写如主存。这样就保证了可见性
 *
 *  为了便于程序员理解记忆，java总结了一套happens before原则，用来说明在什么情况下可以保证可见性
 *  1、volatile原则，对volatile变量的写 happens before 对他的读
 *  2、监视器原则，对监视器锁的释放 happens before 对他的获取
 *  3、中断原则，对一个线程的中断方法调用 happens before 这个线程检测到自己被中断
 *  4、线程终结原则 一个线程内的任何动作都 happens before 其他线程检测到这个线程死亡
 *  5、传递原则 如果A happens before B,B happens before C,那么A happens before C
 *  6、程序顺序原则 在同一个线程内部，前面的操作都 happens before 后面的任何一个操作
 *  7、终结器原则 调用对象构造方法的结束 happens before 调用这个对象的终结器方法的开始
 *  8、线程启动原则 调用一个线程的start方法 happens before 这个线程内的所有操作
 *
 *  大白话就是 如果A happens before B，那么A的操作及A之前的所有操作，对B都是可见的。
 *  操作可见就是，A对共享变量做的修改，对B是可见的。
 *
 * @author liujianxin
 * @date 2018-07-30 10:50
 **/
public class VolatileDemo {
    
    public static void main(String[] args) throws Exception {
        new ThreadVolatile().start();
        new ThreadVolatile().start();
        
        new ThreadNoVlolatile().start();
        new ThreadNoVlolatile().start();
        
        Thread.sleep(2000);
        
        System.out.println("volatile int:" + ThreadVolatile.getCount());
        System.out.println("No volatile int:" + ThreadNoVlolatile.getCount());
    }
    
    /**
     * 演示多个线程同时操作被volatile关键字修饰的计数器
     */
    static class ThreadVolatile extends Thread {
        
        private volatile static int count = 0;
        
        @Override
        public void run() {
            while (count < 10000) {
                count++;
            }
        }
        
        public static int getCount() {
            return count;
        }
    }
    
    static class ThreadNoVlolatile extends Thread {
        
        private static int count = 0;
        
        @Override
        public void run() {
            while (count < 10000) {
                count++;
            }
        }
        
        public static int getCount() {
            return count;
        }
    }
    
    
}
