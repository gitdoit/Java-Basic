package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * �����Ŀ����Ϊ���ݵ�����������ṩһ��������������΢���ӿ��еĸ��ֻ�������
 * ��������ʵ�ֶԳ���Ĺ���Ч�������ǳ��ߡ�
 * ���������Ĺ��췽������Ҫ�ṩһ���ײ������/���������InputStream/OutputStream������˵�����ಢ����ֱ�������������ݵģ������ṩ��һ������ء�
 * �û���صĹ��췽��������һ�㣬���趨�Ƿ�ָ������ش�С����һ�㶼��ָ����Ĭ�ϼ��ɡ�
 * 
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
//		FileOutputStream fos = new FileOutputStream("e:\\liujianxin.txt");
//		BufferedOutputStream bfos = new BufferedOutputStream(fos); ��һ�д�����ʽ
		
		BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("e:\\liujianxin.txt"));//�����ڲ�����
		bfos.write("�����޵г�����".getBytes());
		bfos.close();//ֻҪ�رջ���ؾͿ���
		
	}
}
