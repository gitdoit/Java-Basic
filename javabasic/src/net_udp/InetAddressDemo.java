package net_udp;
import java.io.IOException;
/*
 * ����������ʾjava����η�װһ��IP��ַ
 * ������InetAddress �еľ�̬��������ַ��װ��һ��IP����
 * 
 * PID ������Ϊÿһ�����̷����һ��ID����������˿ں�
 * ���netstat -nao �鿴PID���Ӧ�Ķ˿ں�
 * 0-1024Ϊϵͳ����������ϵͳ����ʹ�õĶ˿ںš�
 * 1025-65535Ϊ����ʹ��
 * 
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws Exception {
		//����ָ�����������ƣ���õ�ַ
		InetAddress ip = InetAddress.getByName("DESKTOP-K7IID8L");
		InetAddress ip2 = InetAddress.getByName("www.baidu.com");
		InetAddress ip3 = InetAddress.getByName("180.97.33.107");
		InetAddress ip4 = InetAddress.getByAddress(new byte[] {117,67,11,17});
		System.out.println(ip2.getHostAddress());
		//�ж��Ƿ�ɴ�
		System.out.println(ip.isReachable(2000));
		//��ȡʵ����IP��ַ+������
		System.out.println(ip.getHostAddress()+"---"+ip.getHostName());
		
		//��Ӧ��ȫ�޶�����
		System.out.println(ip.getCanonicalHostName());
		
		
	}

}
