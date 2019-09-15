package top.seefly.javase.old2017.thread;
/*
 * 如果线程处于阻塞状态时调用该线程的interrupt方法，会使该线程出现异常，然后结束该线程。
 * */
public class InterrupteDemo {

	public static void main(String[] args) {
		InterDemo r = new InterDemo();
		Thread t = new Thread(r);
		t.start();
		t.interrupt();//中断该线程(不是结束该线程)，将中断位置true
		
	}

}

class InterDemo implements Runnable{
	@Override
	public void run() {
		try {
			for(int i = 0;i < 1000000;i++);//延时，防止主线程中的(t.interrupt)在子线程下面语句执行后才执行
			System.out.println("子线程是否被中断了："+Thread.currentThread().interrupted());//此方法会检测中断状态位，且返回该中断状态，然后将之重置为false
			System.out.println("线程将进入休眠，且中断状态为："+Thread.currentThread().isInterrupted());//该方法只返回中断状态，但不会对其做任何操作
			Thread.currentThread().sleep(1000);
			System.out.println("线程休眠完成");
			
		}
		catch(InterruptedException  e) {
			e.printStackTrace();
		}
	}
}