package thread;
//Thread�еľ�̬�������˷������׳�һ���ؼ��쳣InterruptedException
//sleep(delayMs) ����˷�����ͬ��������ڱ����ã���ô���̻߳�������ߡ�1000ms = 1s
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
