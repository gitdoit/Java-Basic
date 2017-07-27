package thread;
/*
 * yield()�����ǽ����Լ���ִ��Ȩ�ޣ�ʹ�Լ���ִ��̬ǿ��ת��Ϊ����̬��������������Դ��
 * �ò������õ��ֵ���Դ��yield�������ˣ����ó���ִ��Ȩֻ�ܱ�ͬ�Ȼ�ߵ����ȼ����߳����ᡣ(������ʱû��������������߳�ʱ��������ȼ����߳�Ҳ��õ�ִ��Ȩ)
 * �������ʹ�������߳���ͣһ��
 * ע�⣬����sleep������ͬ��sleep������ʹ���߳�ǿ�ƽ�������̬������ָ��ʱ����ת��Ϊ����̬��
 * ��yield������ʹ���̴߳�ִ��̬תΪ����������������
 * ����Ȼ������ͬ��������ڵ���yield��ô���̲߳����ͷ���
 * 
 * */
public class YieldDemo {
	public static void main(String[] args) {
		YieldRun r = new YieldRun();
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);//�����߳����ȼ���JAVA�н�֮��Ϊ10�������ṩ���������ȼ����������ڲ�ͬ��OS�ж�������ͬ������û�����ȼ���
		t2.setPriority(Thread.MIN_PRIORITY);//����΢���OS�������ȼ���Ϊ7�������ߵ����ȼ������Ÿ����ִ�л���
		t.start();
		t2.start();
	}
}

class YieldRun implements Runnable{
	@Override
	public void run() {
		int i = 0;
		while(i < 50) {
			if(i == 20)
				Thread.yield();//�� i == 20ʱ��������ͣһ��
			System.out.println(Thread.currentThread().getName()+"  :"+i++);
		}
		
	}
}
