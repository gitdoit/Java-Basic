package net_udp;
/* 2017��7��24��
 * ���裺
 * 1���������ܶ�Socket����ָ�����ն˿�
 * 2���������ݰ������洢���յ�����
 * 3��socket����������������
 * 4�����������
 * 5���ر���Դ
 * 
 * 		UDP�е�socket�����ڽ�������ʱҪָ�����ĸ��˿ڽ������ݡ�
		���������ݰ������������ݰ�ֻҪָ���ֽ����飬�������ݵ���󳤶ȼ��ɡ�
		
		����ͨ���������ݰ���getLength������ȡ�������ݵ���ʵ���ȡ�
		ͨ������getData��ȡ���ݵ��ֽ����顣
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiveDemo {

	public static void main(String[] args) throws Exception{
		//1 ����socket����ָ���˿�
		DatagramSocket get = new DatagramSocket(10086);
		//2��������
		byte[] bt = new byte[1024];
		DatagramPacket pg = new DatagramPacket(bt,1024);
		//3,����ʱ���������ô˷�������ɳ���������һֱ���ڽ���״̬��֪���յ�����
		get.receive(pg);
		//4�������ݣ������
		String ip = pg.getAddress().getHostAddress(); 
		String name = pg.getAddress().getHostName();
		System.out.println(ip+":" + name +  ":"  +new String(pg.getData(),0,pg.getLength()));
		System.out.println("������"+pg.getLength()+"���ݳ�:"+pg.getData().length);
		//5�ر���Դ
		get.close();
	}

}
