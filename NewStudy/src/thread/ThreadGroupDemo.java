package thread;

public class ThreadGroupDemo {
	public static void main(String[] argws) {
		//新建线程组，指定其父线程组为主线程组。设置父线程组的目的是为了使用父线程组中的uncaugthException的处理方法
		//即使出现了线程未捕获异常被线程组的uncaughtException捕获了，那么出现线程的异常也会停止。将异常抛向上级
		ThreadGroup g = new ThreadGroup(Thread.currentThread().getThreadGroup(),"MyThreadGroup") {//重写线程组的未捕获异常处理器
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("线程组g的未捕获异常处理器,异常线程为"+t.getName()+"  "+e);
			}
		};
		
		
		g.setDaemon(true);//设置是否为后台线程组，组内所有线程皆受改变
		
		
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
				System.out.println("重写Thread类的默认未捕获异常处理器");
				
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
		System.out.println("主线程组名称:"+g1.getName()+"是否为后台线程"+g1.isDaemon());
		System.out.println("自定义线程组名称:"+g.getName()+"是否为后台线程"+g.isDaemon());
		System.out.println("线程组："+g.getName()+"活动的线程数为"+g.activeCount());
		g.interrupt();//如果线程内有被阻塞的线程，那么调用该方法，会让被阻塞的线程抛出异常导致该线程结束。
					//如果线程组内所有线程都没有被阻塞，那么调用此方法将不起任何作用
		try {
			Thread.currentThread().sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("调用interrupt之后活动的线程数为:"+g.activeCount());
	}
}

