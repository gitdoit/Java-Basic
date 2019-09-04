package io;
/*
 * DataInputStream��DataOutputStream�ֱ�̳���FileInputStream��FileOutputStrem
 * ����ʵ����DataInput��DataOutpu�ӿ�
 * ����ʹ����ƽ̨�޹صķ��������ļ��ж�дָ���ֽڳ��ȣ���ת���ɶ�Ӧ���������͡�
 * 
 * ע�⣬writeXXX��readXXXҪ��Ӧ��ϵͳ������Ϊ��ָ����writeInt()�ʹ��ļ���ѡȡ��һ�α�ʾintֵ���ֽڽ���ת����
 * ��ֻ�Ǵ���һ�ζ�ȡ��¼λ�ÿ�ʼ������ָ���ķ�����ȡָ�����ֽڸ���UTF-8�޸İ��������ת����
 * 
 * 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class DataStreamDemo {

	public static void main(String[] args) throws IOException {

		
		
		writer();
		reader();
	}
	
	public static void writer() throws IOException {
		DataOutputStream dop = new DataOutputStream(new FileOutputStream("e:\\IOTest\\datatest.txt"));//����������
		dop.writeChar(65);//д�������ֽڡ��洢char
		dop.writeInt(33);//д��˸��ֽڣ��洢intֵ
		dop.writeDouble(77);//д��8���ֽڣ��洢doubleֵ
		dop.writeUTF("������");//ʹ��������޹صķ�ʽ�����ļ�д��һ���ֽڴ����ô���ͷʹ�����ֽڱ�ʾ�ַ����ȡ���Ӧ��readUTF���Խ����
		dop.close();
	}
	
	public static void reader() throws IOException{
		DataInputStream dip = new DataInputStream(new FileInputStream("e:\\IOTest\\datatest.txt"));
		byte[] bt = new byte[2];//���ļ��ж�ȡ2���ֽڣ���ʹ��ָ���Ľ��뷽ʽת�����ַ���
		dip.read(bt);
		String  str = new String(bt,"GBK");//����ָ�����뷽ʽ������ѡ��ƽ̨Ĭ��
		System.out.println(str);
		
		System.out.println(dip.readInt());//���ļ����Ǹ���ȡ8���ֽڣ�ת����int
		System.out.println(dip.readDouble());//���ļ��ж�ȡ8���ֽڣ�ת����double
		System.out.println(dip.readUTF());//���ļ��ж�ȡһ����UTF-8�޸İ������ַ���(��ϸ��DataInput�ӿ�)
		dip.close();
	}
	
	

}
