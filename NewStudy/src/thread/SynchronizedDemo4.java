package thread;
/*
 * 本类演示了只有一个消费者，和一个生产者中的    wait()--等待,和notify()--唤醒  方法的使用，
 * 这两个方法都定义在Object类中，因为任何对象都具有锁的性质，而这两个方法是以锁为操作对象的方法。
 * 
 * wait方法会将当前线程放入线程池中，并将锁释放。
 * 而notify会将线程池中的第一个线程唤醒。并将锁交给他
 * 
 * 注意，这两个方法只能使用在synchronized块或方法中。因为在它之外就没有锁这个概念了。而这两个方法正是基于锁而操作的。
 * 
 * 效果是input之后执行output，实现了交替工作。而不是由CPU随机分配资源
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
				r.set("张三", "女");
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