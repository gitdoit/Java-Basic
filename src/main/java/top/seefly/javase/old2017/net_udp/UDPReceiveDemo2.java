package net_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo2 {
	public static void main(String[] args) throws IOException {
		String strMes = "";
		//�½�socket����
		DatagramSocket ds = new DatagramSocket(10086);
		byte[] bytMes = new byte[1024];
		//�հ�����������
		DatagramPacket pg = new DatagramPacket(bytMes,1024);
		
		do{
			//��������
			ds.receive(pg);
			//����
			strMes = new String(pg.getData(),0,pg.getLength());
			//��ʾ
			System.out.printf("form %s message:%s/n",pg.getAddress().getHostName(),strMes);
		}while(!strMes.equals("close"));
		ds.close();
	}
}
