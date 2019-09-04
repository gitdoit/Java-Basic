package io;
/*
 * IO���ķ���
 * 	����
 * 		���������������
 * 		��������ӳ�������
 * 	�������ͣ�
 * 		�ֽ���(�ײ���)
 * 			�ֽ�������  	����(abstract) �� InputStream
 * 										----FileInputStream(File f\String filePathName)
 * 			�ֽ������ 	���� (abstract)�� OutputStream
 * 										----FileOutputStream(File f\String filePathName)
 * 
 * 		�ַ���(ת����)							
 * 			�ַ�������  ����(abstract) ��Reader
 * 										----InputStreamReader(InputStream in)
 * 			�ַ������  ����(abstract) ��Writer
 * 										----OutputStreamWriter(OutputStream out)
 * 
 * һ��������IO��ʱ��û��ָ�������ַ�ʽ���࣬Ĭ��Ϊ���������ͷ���
 * ע�⣺һ��FileInputStream������ļ��ж����ݣ��������֮���ڶ������read����ô��ʲô��������������Ϊ����ָ���Ѿ��ƶ���ĩβ��
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo {

	public static void main(String[] args) throws Exception {
		FileInputStream fis  = new FileInputStream("e:\\liujianxin.txt");//����ṩԴ�ļ������ڣ���FileNotFoundException
		byte[] bt = new byte[2];//�����ֽ�����
		System.out.println("�ɹ��´ζ�ȡ���ֽ���Ϊ��"+fis.available());
		 int  hasRead;
		 //read(bt,starIndex,len),������starIndexλ�ÿ�ʼд�볤��Ϊlen���ֽڡ�����ȡ����������ʱ������-1
		 //read() �޲η���������ֵ��һ��int������ȡ���ֽڡ�����ȡ����������ʱ������-1
		 while((hasRead = fis.read(bt)) > 0) {//read(byte[])������ָ���ļ����ֽ�������ʽд��byte�����д�볤�������鳤�ȡ�����ֵ�Ǳ���д�볤�ȡ�
			 									//����ȡ�����ǣ�����ֵΪ-1
			 System.out.print(new String(bt,0,hasRead));//String(�ֽ����飬Ĭ�Ͻ��뷽ʽ���������ж�ȡ�ĳ���)
		 }
		fis.close();
		 

	}

}
