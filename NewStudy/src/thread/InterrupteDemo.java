package thread;
/*
 * ����̴߳�������״̬ʱ���ø��̵߳�interrupt��������ʹ���̳߳����쳣��Ȼ��������̡߳�
 * */
public class InterrupteDemo {

	public static void main(String[] args) {
		InterDemo r = new InterDemo();
		Thread t = new Thread(r);
		t.start();
		t.interrupt();//�жϸ��߳�(���ǽ������߳�)�����ж�λ��true
		
	}

}

class InterDemo implements Runnable{
	@Override
	public void run() {
		try {
			for(int i = 0;i < 1000000;i++);//��ʱ����ֹ���߳��е�(t.interrupt)�����߳��������ִ�к��ִ��
			System.out.println("���߳��Ƿ��ж��ˣ�"+Thread.currentThread().interrupted());//�˷��������ж�״̬λ���ҷ��ظ��ж�״̬��Ȼ��֮����Ϊfalse
			System.out.println("�߳̽��������ߣ����ж�״̬Ϊ��"+Thread.currentThread().isInterrupted());//�÷���ֻ�����ж�״̬��������������κβ���
			Thread.currentThread().sleep(1000);
			System.out.println("�߳��������");
			
		}
		catch(InterruptedException  e) {
			e.printStackTrace();
		}
	}
}