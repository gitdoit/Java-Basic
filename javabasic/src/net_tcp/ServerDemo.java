/**
 * 
 */
package net_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liujianxin
 *
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException{
		//������������Socket����ָ�������˿�
		ServerSocket ss = new ServerSocket(8888);
		//�����˿ڣ����ָ����Socket����
		Socket sk = ss.accept();
		//��ȡ���������ӡ�ӽӿڽ��յ�������
		InputStream input = sk.getInputStream();
		byte[] bt = new byte[1024];
		int len = input.read(bt);
		String str = new String(bt,0,len);
		System.out.println(str);
		
		OutputStream out = sk.getOutputStream();
		out.write("�����������յ���".getBytes());
		//sk.close();��������Ӧ�ùر�
	}

}
