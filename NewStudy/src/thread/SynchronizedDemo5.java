package thread;
/*
 * �����Ŀ������ʾ����̲߳���ִ��ʱ�����⡣
 * �������������Լ����������ߣ����ǵ�Ŀ��������һ������һ����
 * ����ͨ��flag��־λȷ�����������ѽ���ʵ�֡�
 * 
 * ���while �� notifyAll ���� if �� notify �������������
 * �����if�ж�flag��־λ����ô��ͬ�������ڣ�t1��ʼִ�л����Դ�ж�flagΪ�٣�����wait��ִ�к�����䡣����ʱ��Ƭ�ù�֮ǰ��ִ�е���if����ʱflagΪ��
 * t1�ȴ����ͷ�����t2���ִ����Դ���ж�flagҲΪ�棬Ҳ�ȴ����ͷ�����t3�����Դ�ж� ��flag Ϊ�٣�����wait��ִ�����ѡ��������ʼ�����̳߳ص�t1����������t1��ִ����Դ��Ҫ������Ȼ��t3��ִ����һ��
 * ��if��ʱ���ж�flag������ȴ����ͷ��ʸ����ñ�t4������t4һ�ж�Ҳ����ȵ������ʸ񡣴�ʱֻ��t1���ţ�������֮��������һ����Ʒ��������t2��֮������һ���жϲ������˵ȴ���ֻ��t2���ţ��õ�����Դ��
 * ��Ϊ�ȴ�֮ǰ�Ѿ��жϹ�flag������ֱ������ִ�У�Ҳ������һ����Ʒ��������ͳ�������������������Ʒ������
 * 
 * */
public class SynchronizedDemo5 {
	public static void main(String[] args){
		Resource res = new Resource("��Ʒ");
		
		producer pro = new producer(res);
		consumer con = new consumer(res);
		
		Thread t1 = new Thread(pro,"������1��");
		Thread t2 = new Thread(pro,"������2��");
		Thread t3 = new Thread(con,"������1��");
		Thread t4 = new Thread(con,"������2��");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class Resource{
	private String name;
	private int count = 0;
	private boolean flag = false;
	
	public Resource(){
	}
	
	public Resource(String name){
		this.name = name;
	}
	
	public synchronized void production(){
		while(flag)
			try{this.wait();} catch(Exception ex){}
		//this.name = name+" **** "+count++;
		System.out.println(Thread.currentThread().getName()+" ��" + name + "********" + count++);
		this.flag = true;
		this.notifyAll();
	}
	
	public synchronized void consume(){
		while(!flag)
			try{this.wait();} catch(Exception ex){}
		System.out.println(Thread.currentThread().getName()+" ��" + name + "    " + count);
		this.flag = false;
		this.notifyAll();
		
	}
	
}

class producer implements Runnable{
	private Resource res;
	
	public producer(Resource res){
		this.res = res;
	}
	
	public void run(){
		while(true)
			res.production();
	}
}

class consumer implements Runnable{
	private Resource res;
	public consumer(Resource res){
		this.res = res;
	}
	
	public void run(){
		while(true)
			res.consume();
	}
}