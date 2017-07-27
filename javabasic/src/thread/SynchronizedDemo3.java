package thread;
/*
 * ������ʾ�ˣ����ڲ�ͬ��ͬ������飬���ʹ����ͬ��������ô��ʹ�ж���߳�����Ҳ���Ტ��ִ�С�
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
			synchronized(this){//ʹ��this�ؼ��ִ�������߱�������ÿ���߳�ʹ�õĶ���ͬһ����
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