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
		//创建服务器端Socket对象，指定监听端口
		ServerSocket ss = new ServerSocket(8888);
		//监听端口，获得指定的Socket对象
		Socket sk = ss.accept();
		//获取输出流，打印从接口接收到的数据
		InputStream input = sk.getInputStream();
		byte[] bt = new byte[1024];
		int len = input.read(bt);
		String str = new String(bt,0,len);
		System.out.println(str);
		
		OutputStream out = sk.getOutputStream();
		out.write("服务器：我收到了".getBytes());
		//sk.close();服务器不应该关闭
	}

}
