package thread;
/*
 * ������ʾ��ֻ��һ�������ߣ���һ���������е�    wait()--�ȴ�,��notify()--����  ������ʹ�ã�
 * ������������������Object���У���Ϊ�κζ��󶼾����������ʣ�������������������Ϊ��������ķ�����
 * 
 * wait�����Ὣ��ǰ�̷߳����̳߳��У��������ͷš�
 * ��notify�Ὣ�̳߳��еĵ�һ���̻߳��ѡ�������������
 * 
 * ע�⣬����������ֻ��ʹ����synchronized��򷽷��С���Ϊ����֮���û������������ˡ����������������ǻ������������ġ�
 * 
 * Ч����input֮��ִ��output��ʵ���˽��湤������������CPU���������Դ
 * 
 * */
public class SynchronizedDemo4 {
	public static void main(String[] args){
		Res r = new Res();
		
		
		/*Input in = new Input(r);
		Output out = new Output(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		
		t1.start();
		t2.start();*/
		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
	}

}
class Res{
	private String name;
	private String sex;
	private boolean flag = false;
	
	public synchronized void set(String name,String sex){
		if(flag)
			try{this.wait();} catch(Exception ex){};
		this.name = name;
		this.sex = sex;
		this.flag = true;
		this.notify();
	}
	
	public synchronized void out(){
		if(!flag)
			try{this.wait();} catch(Exception ex){};
		System.out.println(this.name+"******"+this.sex);
		this.flag = false;
		this.notify();
	}
}

class Input implements Runnable{
	private Res r;
	private int i = 0;
	Input(Res r){
		this.r = r;
	}
	public void run(){
		while(true){
			if(i == 0)
				r.set("����", "Ů");
			else
				r.set("Michael", "men");
			i = (i+1)%2;
		}
	}
}

class Output implements Runnable{
	private Res r;
	Output(Res r){
		this.r = r;
	}
	
	public void run(){
		while(true)
				r.out();
		}
}