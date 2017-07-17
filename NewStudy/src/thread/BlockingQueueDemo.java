package thread;
/*
 * �����жӵ��������ڶ��̻߳�������ͬ����Ŀ�ġ�
 * ����̶߳�һ�������жӽ��в�����ʹ��BlockingQueue.put()���������������������������̣߳��Ȳ�����ʱ����Զ����� 
 * 
 * BlockingQueue<T>��һ���ӿڡ��ӿ��к������з���
 * 
 * 
 * boolean offer(T:e)/(T:e,long , TimeUnit)
 * �������жӵĶ�β�з���e����� ���� ��������ô������false���������������ô��int * TimeUnitʱ��֮�������Ľ�����false��
 * �˷�����ʹ�߳��ڸô�ͣ���ȴ�long * TimeUnit���ȵ�ʱ�䡣
 * T poll()/(long,TimeUnit)
 * �������ж�ͷ��ȡ��Ԫ�أ����û���򷵻�null�������long * TimeUnitʱ��֮��û�У���ô������null��
 * �˷�����ʹ�߳��ڸô�ͣ���ȴ�long * TimeUnit
 * T peek()
 * �������ж���ȡ��ͷ��Ԫ�أ��Ҳ�ɾ��
 * 
 * boolean add(T:e)
 * �������ж�β����Ԫ�أ����������������ô���׳��쳣.
 * T remove()
 * �������ж�ͷ��ȡ������ɾ����Ԫ�ء��������Ϊ�գ���ô���׳��쳣��
 * boolean remove(T:e)
 * �������ж���ȡ����Ԫ�أ����û���ҵ����Ԫ�أ���ô����false�����򷵻�true
 * T element()
 * �������ж�ͷ��ȡԪ�أ��Ҳ�ɾ����������Ϊ�գ����׳��쳣
 * 
 * void put(T:e)
 * �������ж�β������Ԫ�أ���������Ѿ����ˣ���ô���ô˷������߳̽����������̬��ֱ�������п�λ��
 * T take()
 * �������ж�ͷ��ȡԪ�أ��������Ϊ�գ���ô���ô˷������߳̽����������̬��֪����������Ԫ�ء�
 * 
 * 
 * */
import java.util.concurrent.*;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		Producer1 p = new Producer1(queue);
		Consumer1 c = new Consumer1(queue);
		Thread t = new Thread(p);
		Thread con = new Thread(c);
		Thread con1 = new Thread(c);
		t.start();
		//con.start();
		//con1.start();

	}

}

class Producer1 implements Runnable{
	private BlockingQueue<String> queue;
	public Producer1(BlockingQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		boolean isRunning = true;
		boolean isInsert;
		System.out.println("�����������̣߳�");
		try {
			while(isRunning) {
				System.out.println("����������Ʒ");
				Thread.currentThread().sleep((int)(Math.round(1000)));
				isInsert = queue.offer("productiong",2, TimeUnit.SECONDS);//������֮�������߻�û������Ʒ����ô�˳�
				if(!isInsert) {
					isRunning = false;//if insert failed then exit this thread
					System.out.println("�˳��������߳�");
				}
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}


class Consumer1 implements Runnable{
	private BlockingQueue<String> queue;
	private String isGet;
	private boolean isRunning = true;
	@Override
	public void run() {
		try {
			while(isRunning) {
				System.out.println("����ȡ����Ʒ");
				Thread.currentThread().sleep((int)(Math.round(1000)));
				isGet = queue.poll(2,TimeUnit.SECONDS);//get the goods
				if(isGet != null) {
					System.out.println("�������Ѳ�Ʒ--"+isGet);
				}
				else//������֮��û����Ʒ����������ô���˳��̡߳�
					isRunning = false;
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Consumer1(BlockingQueue queue) {
		this.queue = queue;
	}
	
	public void setRunning(boolean flag) {//�����߳�ֹͣ
		this.isRunning = flag;
	}
}
