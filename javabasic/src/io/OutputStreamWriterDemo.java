package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * �ַ������
 * Object
 * 		Writer
 * 			OutputStreamWriter
 * 				FileWriter
 * 
 * public void writer(int chr)дһ���ַ�
 * public void writer(char[] chr)дһ���ַ�����
 * public void writer(char[],starIndex,len) ָ��λ�ü�����д���ַ������ĳ����
 * public void writer(String str)дһ���ַ���
 * public void writer(Sting str,int starIndex,len)ָ��λ�ü�����д���ַ�����ĳ����
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		OutputStreamWriter wtr = new OutputStreamWriter( new FileOutputStream("e:\\writer.txt"));//����ʹ��Ĭ�ϱ���GBK
//		OutputStreamWriter wtr1 = new OutputStreamWriter(new FileOutputStream("writer.txt"),"UTF-8");//����ָ�����룬�ļ��ڱ���ĿĿ¼��
		char[] c = {'s','b','c','��'};
		String str = "|Sting����|";
//		wtr1.write("UTF-8�������");	//�����ַ�����������һ���ļ����в��������Ƕ�������Դ�ļ����Ƿ������ݣ����Ǵӿ�ͷд�롣
									//ͬ�������ַ���������ͬһ���ļ�����������ͬ�ļ���ͷ����
//		wtr1.flush();�������������������ˢ�£���close������������������
//		wtr1.close();//���ļ���д���ݣ��˷����ĺ�����ˢ�»���أ���������ص����ݳ����ļ��ڣ������ر����ϵͳ��Դ��
		
		wtr.write(str);//|Sting����|
		wtr.write(str, 6, 2);//|Sting����|����
		wtr.write(c);//|Sting����|����abc��
		wtr.write(c, 3, 1);//|Sting����|����sbc����
		wtr.close();
		
	}
}
