package io;
/*
 * ����������ʾ������ĳ�ʼ���Լ�����д����
 * 
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOutputDemo {

	public static void main(String[] args) throws IOException {
		//����ϵͳ��Դȡ�����ļ�������ļ��Ѿ����ڣ�ֱ���½�FileOutputStream����ָ���������ļ������ڣ����½�֮��ָ����
		FileOutputStream fos = new FileOutputStream("e:\\liujianxin.txtg");
		String str;
		Scanner in = new Scanner(System.in);
		System.out.println("������һ�λ�");
		str = in.nextLine();
		byte[] bt = str.getBytes();//���ַ���ת�����ֽ�����
		byte[] bt1 = {65,66,67,68};
		fos.write(65);//����һ���˷������ļ�д��һ��ASCII��ʾ���ַ�
		fos.write(bt);//���������ֽ���ֻ�����ֽڣ����Խ��ֽ������ʾ���ַ���������ļ�
		fos.write(bt1, 1, 3);//���������������±�Ϊ1��ʼ���±�Ϊ3������1��2��3����д���ļ�.
		
//		String Chinese = "�л����񹲺͹�";   �����������ֽڱ�ʾ(һ��Ӣ����ĸ������һ���ֽ�)�������ͨ����һ���ֽ��Ƿ�Ϊ�������ж�����ַ��Ƿ�������
//		byte[] byt2 = Chinese.getBytes(); �����һ���Ǹ�������ôֱ�ӽ��ڶ����ֽ���֮ƴ���γ�����
//		System.out.println(Arrays.toString(byt2));
		
		fos.close();
		//������ʹ�����֮��һ��Ҫ�ر�
		//�رտ���֪ͨ�������������ոö��󣬲�֪ͨϵͳ��������ļ���ص���Դ

	}

}
