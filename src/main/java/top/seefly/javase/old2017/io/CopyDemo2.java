package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * �����ı��ļ���ʹ�ô�ӡ��������ǿ
 * ��e:\\IOTest\\src.txt��ͬĿ¼�µ�tar.txt
 */
public class CopyDemo2 {

	public static void main(String[] args) throws IOException{
		//ԭ���ķ���
//		BufferedReader br = new BufferedReader(new FileReader("e:\\IOTest\\src.txt"));
//		BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\IOTEst\\tar.txt"));
//		
//		String str = null;
//		while((str = br.readLine()) != null) {
//			bw.write(str);//д��һ����
//			bw.newLine();//���½�һ��
//			bw.flush();//��ˢһ��
//		}
//		br.close();
//		bw.close();
		

		BufferedReader br = new BufferedReader(new FileReader("e:\\IOTest\\src.txt"));
		PrintWriter pw = new PrintWriter(new FileOutputStream("e:\\IOTest\\tar.txt"),true);//���ô�ӡ�������Զ���ˢ
																							//��Ȼû����ȷָ���˴�ӡ���л���أ����ڲ��Ѿ���װ����
		
		String str = null;
		while((str = br.readLine()) != null) {
			pw.println(str);//����һ�е�ͬ������ͬλ�õ�����
		}
		br.close();
		pw.close();
	}

}
