package net_udp;
/*2017��7��24��
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPSendDemo2 {

	public static void main(String[] args) throws IOException{
		//newһ��socket����
		DatagramSocket ds = new DatagramSocket();
		String str = "";
		byte[] bt = new byte[1024];
		//������ָ�����
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("�㣺");
			//�Ӽ��̵õ��ַ���
			str = input.readLine();
			bt = str.getBytes();
			//���ݴ��
			DatagramPacket pg = new DatagramPacket(bt,bt.length,InetAddress.getByName("192.168.3.4"),10086);
			//����
			ds.send(pg);
			
		}while(!str.equals("close"));
		input.close();
		ds.close();
	}

}
