package thread;
/*��ʾ�˶��̵߳Ļ�������
 * Thread�Ķ��壺public class Thread extends Object implements Runnable
 * Thread���췽��:public Thread(Runnable target,String name)
 * 				public Thread(Runnable target)
 * Thread����������Ҫ������һ���������start,����ͨ���ú��������̣߳���ʵ������������run������������run���Զ���ĺ�����
 * ��һ����run�����Կ�����ʵ����Runnable�ӿڡ�
 * �����������̵߳ķ�ʽ�����´����������
 * 
 * interface Runnable
 * �ӿ�Runnable��ֻ��һ�����󷽷���public abstract run();
 * ʵ�ָó��󷽷�����ʵ��run�����з��߳���Ҫ�ܵĶ���
 * 
 * ע�⣬�������һ���̶߳���֮�����ֱ�ӵ���run��������ô�����൱��û�п����̣߳����������߳���ִ�У���ͺ���ͨ�ĵ���û��������
 * ֻ�е���start�������ܿ���һ�����߳�
 * */

public class MyThread {
	public static void main(String[] args){
		ThreadDemo A = new ThreadDemo("A");//ʵ����Thread��һ������ʵ��
		
		RunnableDemo B = new RunnableDemo("B");//ʵ�����ӿ�Runnable
		
		A.start();//ͨ��A�ڵķ���startֱ�������߳�
		
		new Thread(B).start();//����ʵ��BΪRunnable�ӿ�ʵ���������޷���������ͨ��ʵ����Thread���󣬽�Runnable������������
		
		
		new Thread(new Runnable(){//�в������졣ʵ���������̣߳��ڲ�����ֱ��ʵ����ʵ��
			public void run(){
				System.out.print("�����̣߳���������");
			}
		}).start();
		
		new Thread(){//�޲ι��죬ʵ������ͬʱ��д����run����
			public void run(){
				System.out.println("�����̣߳���дrun");
			}
		}.start();
	}
}

class ThreadDemo extends Thread{//����ֱ�Ӽ̳�Thread������
	private String name;
	public ThreadDemo(String name){
		this.name = name;
	}
	@Override
	public void run(){
		for(int i = 0 ; i < 5 ; i++)
			System.out.println(name + "run" + i);
	}
}

class RunnableDemo implements Runnable{//ʵ��Runnable�ӿڵ���
	private String name;
	public RunnableDemo(String name){
		this.name = name;
	}
	@Override
	public void run(){
		for(int i = 0; i < 5; i++)
			System.out.println(name + "Runnable" + i);
	}
}