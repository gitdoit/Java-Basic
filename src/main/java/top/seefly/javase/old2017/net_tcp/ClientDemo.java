package net_tcp;
/*
 * ����ģ�¿ͻ��ˣ���������������ݡ�
 * ��Ҫ�������ݣ�һ��Ҫ�ȿ������������������ݡ����򱨴�
 * 
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) throws IOException{
		Socket sk = new Socket("192.168.3.4",8888);
		//��ȡ�ܵ�����ӿڣ����Ӵ˹ܵ��������ݡ�
		OutputStream out = sk.getOutputStream();
		//��������
		out.write("������".getBytes());
		//��ȡ�ܵ�����ӿڣ�׼���Ӵ˹ܵ���������
		InputStream in = sk.getInputStream();
		byte[] mes = new byte[1024];
		int len = in.read(mes);//�ڷ�����û�з������ݵ��ͻ���֮ǰ���˷��������������
		System.out.println(new String(mes,0,len));
		out.close();
	}

}
