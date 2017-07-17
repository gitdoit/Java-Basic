package exception;
import java.io.*;
/*
 * 该类演示了几个获取异常信息的方法
 * getMessage():String 返回异常信息详细描述字
 * getStackTrace() 返回该异常的跟踪信息
 * printStackTrace() 打印该异常的跟踪栈信息
 * */
public class MessageOfException {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("a.txt");
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
			ex.printStackTrace();
		}
	}

}
