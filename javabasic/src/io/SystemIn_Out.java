package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * public static final InputStream in  ����׼����������
 * public static final PrintStream out ����׼���������
 * 
 */
public class SystemIn_Out {

	public static void main(String[] args) throws IOException {
		//��̬��������ӡ����ΪPrintStream
		System.out.println("hello world!");
		
		//������ȼۣ�Ŀ��Ϊ��ʾ��
		PrintStream ps = System.out;
		ps.println("hello world!");
		
		Scanner in = new Scanner(System.in);//���ﴫ��Ĳ�����InputStream���͡����ֽ���
		String str = in.nextLine();//֮ǰһֱ��������ʹ�ã��Ӽ��̶������ݣ�һ�ζ�һ��
		
		//ʹ����Դָ�����¼�룬���Ӵ�ǰ�Ĵ��ļ��ж����ݣ�������ڵĴӼ��̶�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1;
		
		
		str1 = br.readLine();
		ps.println(str1);
		ps.println(str);
		ps.close();
		br.close();
		in.close();
		
	}

}
