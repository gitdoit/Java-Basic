package thread;

public class ThreadGroupDemo {
	public static void main(String[] argws) {
		//�½��߳��飬ָ���丸�߳���Ϊ���߳��顣���ø��߳����Ŀ����Ϊ��ʹ�ø��߳����е�uncaugthException�Ĵ�����
		//��ʹ�������߳�δ�����쳣���߳����uncaughtException�����ˣ���ô�����̵߳��쳣Ҳ��ֹͣ�����쳣�����ϼ�
		ThreadGroup g = new ThreadGroup(Thread.currentThread().getThreadGroup(),"MyThreadGroup") {//��д�߳����δ�����쳣������
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("�߳���g��δ�����쳣������,�쳣�߳�Ϊ"+t.getName()+"  "+e);
			}
		};
		
		
		g.setDaemon(true);//�����Ƿ�Ϊ��̨�߳��飬���������߳̽��ܸı�
		
		
		Thread t1 = new Thread(g,new Runnable() {
			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
					//return;
				}
			}
		},"t1");
		
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("��дThread���Ĭ��δ�����쳣������");
				
			}
		});
		Thread t2 = new Thread(g,new Runnable() {
			@Override
			public void run() {
				while(true);
					//System.out.println("t2");
			}
		},"t2");
		
		
		t1.start();
		t2.start();
		ThreadGroup g1 = Thread.currentThread().getThreadGroup();
		System.out.println("���߳�������:"+g1.getName()+"�Ƿ�Ϊ��̨�߳�"+g1.isDaemon());
		System.out.println("�Զ����߳�������:"+g.getName()+"�Ƿ�Ϊ��̨�߳�"+g.isDaemon());
		System.out.println("�߳��飺"+g.getName()+"����߳���Ϊ"+g.activeCount());
		g.interrupt();//����߳����б��������̣߳���ô���ø÷��������ñ��������߳��׳��쳣���¸��߳̽�����
					//����߳����������̶߳�û�б���������ô���ô˷����������κ�����
		try {
			Thread.currentThread().sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("����interrupt֮�����߳���Ϊ:"+g.activeCount());
	}
}

