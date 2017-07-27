package net_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(8888);
		Socket  sk = ss.accept();
		//�ӿͻ��˽�������
		BufferedReader input = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		//ָ���ļ���,����ʹ��BufferedWriter��װһ��
		FileWriter fw = new FileWriter("e:\\IOTest\\TCP.txt");
		fw.flush();
		fw.write("gdffd");
		String str = null;
		//ѭ�����ļ�����д��
		while((str = input.readLine()) != null) {
			fw.write(str);
			fw.flush();
		}
		//�ر��ļ�������
		fw.close();
//		input.close(); ������Բ��رգ���Ϊ�ӿͻ��˽��յģ��ͻ��˷�����ϣ��Զ��ر�
		sk.close();
	}

}
