package top.seefly.javase.old2017.net_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(8888);
		Socket  sk = ss.accept();
		//从客户端接收数据
		BufferedReader input = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		//指定文件夹,可以使用BufferedWriter包装一下
		FileWriter fw = new FileWriter("e:\\IOTest\\TCP.txt");
		fw.flush();
		fw.write("gdffd");
		String str = null;
		//循环向文件夹内写入
		while((str = input.readLine()) != null) {
			fw.write(str);
			fw.flush();
		}
		//关闭文件操作流
		fw.close();
//		input.close(); 这个可以不关闭，因为从客户端接收的，客户端发送完毕，自动关闭
		sk.close();
	}

}
