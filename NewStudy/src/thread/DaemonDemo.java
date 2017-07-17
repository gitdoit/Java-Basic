package thread;
/*
 * ��̨�߳��ֳ�Ϊ�ػ��߳�
 * ���߳���һ���ص��Ǿ��ǣ������߳���������ô��Ҳ��������
 * �����������߳�t1,t2
 * ��t1�߳���new��t2�̣߳����ڵ���start����ǰ
 * ���ã�t2.setDaemon(true) Ȼ��t2.start()
 * ��ʱt2�߳̾ͱ�����Ϊt1�̵߳��ػ��̣߳���t1������t2Ҳ������
 * ע�ⲻҪ���߳�Ϊ����̬������Daemon����ᱨIllegalThreadStateException
 * 
 * */
public class DaemonDemo implements Runnable{
	public static void main(String[] args) {
		DaemonDemo r = new DaemonDemo();
		Thread t = new Thread(r,"t1");
		t.start();
	}
	@Override
	public void run() {//��ǰ̨�̴߳������̶߳�Ϊǰ̨�̣߳���֮��Ϊ��̨�߳�
		Thread t2 = new Thread(new Runnable() {//��t1�߳��ڴ�t2�߳�
			@Override
			public void run() {
				for(int t2 = 0; t2 < 1000; t2++)
					System.out.println(Thread.currentThread().getName()+":t2="+t2);//����ѭ��1000�Σ���t1�̶߳�
			}
		},"t2");
		t2.setDaemon(true);//����Ϊ��̨�߳�
		t2.start();//����
		for(int t1 = 0;t1 < 100; t1++)
			System.out.println(Thread.currentThread().getName()+"t1:"+t1);//t1�߳�ѭ��100��
	}
	
}

