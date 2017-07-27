package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueDemo1 {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		AtomicInteger count =  new  AtomicInteger(0); 
		P p = new P(queue,count);
		V v = new V(queue);
		
		Thread t = new Thread(p);
		Thread t2 = new Thread(v);
		Thread t3 = new Thread(p);
		t.start();
		t2.start();
		//t3.start();
		try {
			Thread.currentThread().sleep(3000);
			p.stop();//������������������߳̿���Ҳ����ֹͣ����Ϊ���ǿ�����Ϊput��take����ʹ�߳������ˣ����������̲߳������ѣ��������̲߳�������
			v.stop();//���Գ�����������
			Thread.currentThread().sleep(1000);
			System.out.println("t:"+t.isAlive()+"t2:"+t2.isAlive()+"t3:"+t3.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class P implements Runnable{
	private BlockingQueue<String> queue;
	private AtomicInteger count;
	private int i = 0;//ʹ��i����ɶ�������
	private volatile int id = 0;//ʹ��volatile�ؼ��ֶ�������ݣ���ʹ���ݸ��ĳ�ԭ�Ӳ��������ݶ�д�������ԡ�������ֶ�������
	boolean flag = true;
	public P(BlockingQueue queue,AtomicInteger count) {
		this.queue = queue;
		this.count = count;
	}
	
	@Override
	public void run() {
		String data;
		try {
			System.out.println("�����������߳�");
			while(flag) {
				//data = "��Ʒ"+i++;��ʹ�� i ���ڶ��̻߳����»���ɶ�������
				data = "��Ʒ" + count.incrementAndGet();//ʹ�ô˷����򲻻��ڻ�ʹ����������ԭ�Ӳ�����������ɶ�������
				//data = "��Ʒ" + id++;����������̶߳�id���и��ģ��������������󡣲�����ֶ�������
				
				queue.put(data);
				System.out.println("�����˲�Ʒ"+data+"���ֿ�����"+queue.size());
				Thread.currentThread().sleep(200);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
			}
	}
	public void stop() {
		this.flag = false;
	}
}

class V implements Runnable{
	private BlockingQueue<String> queue;
	private boolean flag = true;

	public V(BlockingQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		System.out.println("�������߳�����");
		String data;
		try {
			while(flag) {
				data = queue.take();
				Thread.currentThread().sleep(200);
				System.out.println("���Ѳ�Ʒ"+data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void stop() {
		this.flag = false;
	}
}