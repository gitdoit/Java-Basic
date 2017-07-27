package net_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*2017年7月24日
 * UDP：
 *
 *		把数据打包
 *	           数据有限制
 *		不建立连接
 *		速度快
 *		不可靠
 *
 *		Socket在用于UDP的发送时，不需要指定端口或IP地址
 *		IP地址以及端口号需要在建包时被指定。
 *		建包时需要指定发送的数据，数据的真实长度，指定发送地址，以及端口号
 */
public class UDPSendDemo {

	public static void main(String[] args) throws IOException{
	//1.新建发送方UDP的Socket对象
		DatagramSocket sen = new DatagramSocket();
		//2.创建数据
		byte[] mes = "刘建鑫".getBytes();
		int len = mes.length;
		InetAddress ip = InetAddress.getByName("192.168.3.4");
		int port = 10086;//端口，随便定。可能冲突
	    //3.包装数据，包含数据，长度，地址，端口
		DatagramPacket dp = new DatagramPacket(mes,len,ip,port);
		//4.发送数据
		sen.send(dp);
		//关闭资源
		sen.close();
		
		
		
//		DatagramSocket ds  = new DatagramSocket();
//		byte[] mes = "刘建鑫真帅".getBytes();
//		DatagramPacket pg = new DatagramPacket(mes, mes.length,InetAddress.getByName("192.168.3.1"),10086);
//		ds.send(pg);
//		ds.close();
				
	}
	

}
