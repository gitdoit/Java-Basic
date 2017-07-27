package thread;

import java.util.concurrent.*;

/*
 * javaͨ��Executors�ṩ�����̳߳�
 * newCacheThreadPool����һ���ɻ�����̳߳أ������������ģ�����������������Ҫ�����¿����̡߳������ڴ�����Ҫ����ա�
 * newFixedThreadPool����һ�������̶����̳߳أ����������߳���󲢷������������߳��ڶ����еȴ���
 * newScheduledThreadPool ����һ�������̶����̳߳أ�֧�ֶ�ʱ�Լ����ڴ�������
 * newSingleThreadExecutors��������Ϊ1���̳߳أ�ʹ����Ψһ���̴߳������񣬱�֤��������ָ��˳��ִ������(FIFO,LIFO,���ȼ�)
 *http://cuisuqiang.iteye.com/blog/2019372
 * */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		ExecutorService FixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 100; i++) {//ѭ�������̣߳���FixedThreadPool��װ���̳߳�����Ϊ3������ͬʱ�������߳����ֻ������������ĵȴ�
			//cachedThreadPool.execute(new CacheThread());
			FixedThreadPool.execute(new CacheThread());
			//if(i == 7)
				//FixedThreadPool.shutdown();//�˷�����ʹ�߳�ֹͣ����������(�����������ᱨ��)�����������ִ����ȴ��ж��е�����
		ExecutorService CachePool = Executors.newCachedThreadPool();//shutdownNow��ʹ����ִ�е��̴߳����ж�״̬�����ز�����ȴ��ж��е��߳�
		CachePool.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		}
		
	}
}

class CacheThread implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
