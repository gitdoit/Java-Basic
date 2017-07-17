package exception;
import java.io.*;
/*
 * ������ʾ�˼�����ȡ�쳣��Ϣ�ķ���
 * getMessage():String �����쳣��Ϣ��ϸ������
 * getStackTrace() ���ظ��쳣�ĸ�����Ϣ
 * printStackTrace() ��ӡ���쳣�ĸ���ջ��Ϣ
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
