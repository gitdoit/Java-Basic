package thread;
/*
 * ������ʾ�˶���ͬһ��ͬ������飬�������߳�ʹ�ò�ͬ��������ô����̻߳Ტ��ִ�����ͬ�������
 * 
 * */
public class SynchronizedDemo2 {
	public static void main(String[] args){
		runnable p = new runnable();
		Thread t1 = new Thread(p,"t1");
		Thread t2 = new Thread(p,"t2");
		//try{Thread.sleep(50);}catch(Exception ex){}
		t1.start();
		t2.start();
		
	}

}

class runnable implements Runnable{
	private int count = 100;
	public void run(){
		Object a = new Object();//ÿһ���߳̽��������½�һ������ÿ���̵߳�������һ��
		synchronized(a){
			while(count > 0){
				try{Thread.sleep(10);}catch(Exception ex){}
				System.out.println(Thread.currentThread().getName()+ "   ******   "+count--);	
			}
		}			
	}
}

