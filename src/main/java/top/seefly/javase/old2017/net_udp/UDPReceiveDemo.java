package net_udp;
/* 2017年7月24日
 * 步骤：
 * 1，创建接受端Socket对象，指定接收端口
 * 2，创建数据包用来存储接收的数据
 * 3，socket方法用来接收数据
 * 4，解析并输出
 * 5，关闭资源
 * 
 * 		UDP中的socket在用于接收数据时要指定从哪个端口接收数据。
		而容器数据包，即接收数据包只要指定字节数组，接收数据的最大长度即可。
		
		可以通过调用数据包的getLength方法获取接收数据的真实长度。
		通过调用getData获取数据的字节数组。
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiveDemo {

	public static void main(String[] args) throws Exception{
		//1 创建socket对象，指定端口
		DatagramSocket get = new DatagramSocket(10086);
		//2创建包裹
		byte[] bt = new byte[1024];
		DatagramPacket pg = new DatagramPacket(bt,1024);
		//3,阻塞时方法，调用此方法会造成程序阻塞，一直处于接收状态，知道收到数据
		get.receive(pg);
		//4解析数据，并输出
		String ip = pg.getAddress().getHostAddress(); 
		String name = pg.getAddress().getHostName();
		System.out.println(ip+":" + name +  ":"  +new String(pg.getData(),0,pg.getLength()));
		System.out.println("包长："+pg.getLength()+"数据长:"+pg.getData().length);
		//5关闭资源
		get.close();
	}

}
