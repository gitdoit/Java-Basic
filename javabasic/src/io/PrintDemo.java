package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 * ��ӡ����
 * 	printStream �ֽڴ�ӡ��
 * 	printWrite	�ַ���ӡ��
 * 			��������������ǿ��Ի��õģ�Ψһ�Ĳ�����һ������д�ֽڣ�һ�����ܡ�Ҳ����˵printStream����һ�㣬����д�ֽں��ַ�����һ��ֻ��д�ֽ�
 * 			��������ࡣ
 * 	
 * 	��ӡ�����ص㣺
 * 			ֻ��д���ݣ�û�ж����ݡ�ֻ�ܲ���Ŀ�ĵأ����ܲ�������Դ��
 * 			���Բ����������������
 * 			����������Զ�ˢ�£��ܹ��Զ�ˢ��
 * 			��������ֱ�Ӳ����ı��ļ�
 */
public class PrintDemo {

	public static void main(String[] args) throws IOException{
		
		PrintStream ps = new PrintStream(new FileOutputStream("wirter.txt"),true);//����ʵ���Զ�ˢ�£���Ҫ���ô�ln��f�ķ���
		ps.print("������");//�˷���û��ln����ˢ��
		ps.println(true);//д��booleanֵ����ˢ�£����治�õ���close��flush���г�ˢ
		ps.close();
		
		PrintWriter pw = new PrintWriter(new FileOutputStream("wirter.txt",true));//��ָ���Զ���ˢ,������׷�ӡ���������д�ľ�û��
		pw.write(65);// ԭ���wirte����ֻ��д�ַ����ַ�������ַ���,����д��ASCIIΪ65���ַ�
		pw.print(65);//����д��65
		pw.print(true);//���µ�print��������д�����������͡�
		pw.close();
	}

}
