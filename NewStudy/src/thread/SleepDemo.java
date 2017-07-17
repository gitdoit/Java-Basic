package thread;
//Thread中的静态方法，此方法会抛出一个必检异常InterruptedException
//sleep(delayMs) 如果此方法在同步代码块内被调用，那么该线程会持锁休眠。1000ms = 1s
public class SleepDemo {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
