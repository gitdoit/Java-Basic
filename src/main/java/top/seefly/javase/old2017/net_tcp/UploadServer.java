package net_tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ���������ӿͻ��˽������ݣ���д���ļ���
 */
public class UploadServer {

	public static void main(String[] args)throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket sk = ss.accept();
		//�ӹܵ��ڽӸ����Ӷ����ݣ�����װһ��
		BufferedInputStream input = new BufferedInputStream(sk.getInputStream());
		//����һ���ļ�ͨ��
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("E:\\��Ŀ\\ke.7z"));
		byte[] bt = new byte[1024];
		int len;
		while((len = input.read(bt))!= -1) {
			output.write(bt, 0, len);
			output.flush();
		}
		//�ر��ļ�ͨ��
		output.close();
		//��ͻ��˷����ϴ���Ϣ
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
		System.out.println("ssdfsf");
		bw.write("�ϴ��ɹ�");
		bw.newLine();
		bw.flush();
		ss.close();
		
	}

}
