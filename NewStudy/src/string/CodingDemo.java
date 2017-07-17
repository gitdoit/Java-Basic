package string;

import java.io.UnsupportedEncodingException;

/*
 * �ж��ֲ�ͬ�ı�����������ұ��صı������ͬ
 * �й�����Ĭ�ϵ���GBK�����ʹ�������ֽڱ�ʾһ������
 * ��������ʹ�õ���ASCII�����һ���ֽڱ�ʾһ��Ӣ����ĸ
 * ̨����۵�ʹ�÷����ֵĵ���ʹ��BIG-5�����
 * �ձ�ʹ��Shift-JFS
 * 
 * ������Щ����������ڱ���ʹ�ã���������˹��ʱ������һ��ͨ�õı����UTF-8
 * ������ࡿ����ʹ��3���ֽڱ�ʾһ���ַ���һ���ֽڲ��������ֽڣ�����������
 * 
 * ���룺���ַ���ĳ�ֱ����ת�����ֽ�
 * ���룺��ĳ�ֱ�����ֽ�ת�����ַ�
 * 
 */
public class CodingDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "������";
		
		byte[] bt = str.getBytes();//ʹ��ƽ̨Ĭ�ϵı�����ַ�ת�����ֽڣ�������GBK
		String get = new String(bt);//ʹ��Ĭ�ϱ�����ֽ�����ת�����ַ�
		System.out.println(get);
		
		bt = str.getBytes("UTF-8");//����ָ����ʹ��UTF-8���б���
		get = new String(bt);//���ǽ���ȴ����Ĭ�ϵ�GBK�����Գ���������
		System.out.println(get);//刘建�? 
		
		
	}

}
