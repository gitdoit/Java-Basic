package mypraxis;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * await()��wait()���ƣ����ǽ��߳�ǿ��ת��Ϊ����̬await�ȴ�signal()����signalAll.���份�ѽ������̬��
 * �������źŵĳ�����ζ�ţ��������������ˣ���Ҫ���²���һ�Σ��������϶�����ִ��Ҫ��
 * */
public class PVDemo {
	public static void main(String[] args) {
		Computer r = new Computer();
		Thread producer = new Thread(r,"produer");
		Thread consumer = new Thread(r,"consumer");
		producer.start();
		consumer.start();
	}
}

class Computer implements Runnable{
	private int depot = 0;
	private Lock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("produer"))
			while(true) {
				lock.lock();
				try{
					while(depot >= 1) //ѭ���ж��Ƿ�����Ҫ��ע�����ﲻ��ʹ��if�����´α�����֮��ʹ�await�����з����ˣ��������жϾ�ȥִ�������
									//��Ȼ����Ϊ������ֻ�������̣߳����̱߳����ѣ��϶�������ִ�������ˣ���ô�ڸ�����߳����и���������߾Ͳ���������
						con.await();//�����㣬������������ͷ������ȴ�signalAll���ѣ��ٽ����´μ��
					depot++;
					con.signalAll();
					System.out.println("������һ̨����,�ֿ��л�ʣ"+depot+"̨����");
					//Thread.sleep(300);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					lock.unlock();
				}
				for(int i = 0; i < 1000;i++);//��ʱ�����Ӹ��߳�δ��������ʱ�䣬ʹ�������߳��������ĸ�������
											//����������������ʹÿ�ζ�ʹ�ֿ�����
			}
		while(true) {
			lock.lock();
			try{
				while(depot == 0) 
					con.await();
				depot--;
				con.signalAll();
				System.out.println("����һ̨����,�ֿ��л�ʣ"+depot+"̨����");
				//Thread.sleep(300);	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
			//for(int i = 0; i < 100;i++);
		}
	}
}

