package net_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*2017��7��24��
 * UDP��
 *
 *		�����ݴ��
 *	           ����������
 *		����������
 *		�ٶȿ�
 *		���ɿ�
 *
 *		Socket������UDP�ķ���ʱ������Ҫָ���˿ڻ�IP��ַ
 *		IP��ַ�Լ��˿ں���Ҫ�ڽ���ʱ��ָ����
 *		����ʱ��Ҫָ�����͵����ݣ����ݵ���ʵ���ȣ�ָ�����͵�ַ���Լ��˿ں�
 */
public class UDPSendDemo {

	public static void main(String[] args) throws IOException{
	//1.�½����ͷ�UDP��Socket����
		DatagramSocket sen = new DatagramSocket();
		//2.��������
		byte[] mes = "������".getBytes();
		int len = mes.length;
		InetAddress ip = InetAddress.getByName("192.168.3.4");
		int port = 10086;//�˿ڣ���㶨�����ܳ�ͻ
	    //3.��װ���ݣ��������ݣ����ȣ���ַ���˿�
		DatagramPacket dp = new DatagramPacket(mes,len,ip,port);
		//4.��������
		sen.send(dp);
		//�ر���Դ
		sen.close();
		
		
		
//		DatagramSocket ds  = new DatagramSocket();
//		byte[] mes = "��������˧".getBytes();
//		DatagramPacket pg = new DatagramPacket(mes, mes.length,InetAddress.getByName("192.168.3.1"),10086);
//		ds.send(pg);
//		ds.close();
				
	}
	

}
