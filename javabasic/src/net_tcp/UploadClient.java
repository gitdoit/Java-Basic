package net_tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * ���������ϴ��ļ���������
 * ����ط���Ҫ���쳣�Ļ����������ÿ���ط�������Ӧ�Ĵ�������ʹ�ö�Ӧ���쳣����
 */
public class UploadClient {

	public static void main(String[] args) throws IOException{
		Socket sk = new Socket("192.168.3.4",8888);
		//���ļ�������
		BufferedInputStream input = new BufferedInputStream(new FileInputStream("e:\\IOTest\\httpclient.pdf"));
		//��ܵ�д����
		BufferedOutputStream output = new BufferedOutputStream(sk.getOutputStream());
		byte[] bt = new byte[1024];
		int len;
		while((len = input.read(bt)) != -1) {
			output.write(bt, 0, len);
			//������Ķ�Ҫˢ��һ��
			output.flush();
		}
		//************֪ͨ�������ϴ���ϣ�û��Ҫд����******************** //
		sk.shutdownOutput();
		//�����ܵ�����
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		//�ӹܵ�������ʾ,in.readLine()����ֱ�ӷŽ�System.out.println(),������⣬��֪��Ϊʲô
		String str = in.readLine();
		System.out.println(str);
		//�ر��ļ�ͨ��
		input.close();
		//�رտͻ���
		sk.close();
	}

}
