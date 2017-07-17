package thread;
/*
 * ���ͽӿ�Callable<T> ��Runnable�ӿ����ƣ�ͨ����д����call������ʹ�߳�ִ����������
 * �˷�����run������ͬ�������з���ֵ������ֵ�����뷺��һ��
 * ���Ǵ˽ӿڵ�ʵ��ʵ������ֱ�ӷŽ�Thread��ȥִ�У���Ϊ������Runnable�ӿڵ��ӽӿڡ�
 * FutureTask��ʵ����Future�ӿڣ���Runnable�ӿڡ�����Future�ӿڿ��Կ���call������
 * ����������Callable��ʵ��ʵ������FutureTask��ʵ���У�ͨ��FutureTask���Բ���call������
 * �ٽ�Future��ʵ���Ž�Thread��ȥ����������������callab�ӿ�����runnable����ǿ
 * FutureTaks���м���������
 * boolean cancel(boolean mayInterruptIfRunning) ȡ������ִ�е�callab����
 * V get() ��ȡcallable��call�ķ���ֵ��ֻ����call������Ϻ�Ż�õ�����ֵ�����Ի�������ô˷������߳������ȴ�
 * V get(long tiemout,timeUnti unit) ��ȡcall�����ķ���ֵ����������tiemou��unitָ��ʱ����û�з���ֵ����ᱨ��TimeOutException
 * boolean isCancelled() ������������ǰ��ȡ���ˣ��򷵻�true
 * boolean isDone() �����������򷵻�true
 * */
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureDemo implements Callable<Integer>{//����callable�ӿڵ�ʵ����
	@Override
	public Integer call() {//��д����call������ע�ⷵ��ֵ����Ҫ�뷺�Ͷ����һ��
		int i = 0;
		for(; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":i = "+ i);
		}
		return i;
	}
	public static void main(String[] args) {
		FutureDemo f = new FutureDemo();//ʵ����callable��ʵ����
		FutureTask<Integer> task = new FutureTask<>(f);//ʹ��FutureTask���������а�װ
		new Thread(task).start();//��ʹFutureTaksʵ����ΪThread��target��������
		try {//get�������׳��쳣
			System.out.println(task.get());//ͨ������FutureTask��ʵ����call���в���
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

