package top.seefly.javase.old2017.thread;
/*
 * 该类演示了，对于不同的同步代码块，如果使用相同的锁，那么即使有多个线程他们也不会并发执行。
 * */
public class SynchronizedDemo3 {

	public static void main(String[] args) {
		runnable1 p = new runnable1();
		Thread t1 = new Thread(p,"t1");
		Thread t2 = new Thread(p,"t2");
		t1.start();
		t2.start();

	}

}

class runnable1 implements Runnable{
	private int a = 100;
	private int b = 100;
	Object c = new Object();
	public void run(){
		if(Thread.currentThread().getName().compareTo("t1") == 0)
			synchronized(this){//使用this关键字代表调用者本身，所以每个线程使用的都是同一把锁
				while(a > 0){
					try{Thread.sleep(10);}catch(Exception ex){}
					System.out.println(Thread.currentThread().getName()+ "   ******   "+a--);
				}
			}
		else
			synchronized(this){
				while(b > 0){
					try{Thread.sleep(10);}catch(Exception ex){}
					System.out.println(Thread.currentThread().getName()+ "   ******   "+b--);
				}
			}
	}
}