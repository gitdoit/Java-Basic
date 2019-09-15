package top.seefly.javase.old2017.net_tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 本类用来从客户端接收数据，并写入文件内
 */
public class UploadServer {

	public static void main(String[] args)throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket sk = ss.accept();
		//从管道内接根管子读数据，并包装一下
		BufferedInputStream input = new BufferedInputStream(sk.getInputStream());
		//建立一个文件通道
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("E:\\项目\\ke.7z"));
		byte[] bt = new byte[1024];
		int len;
		while((len = input.read(bt))!= -1) {
			output.write(bt, 0, len);
			output.flush();
		}
		//关闭文件通道
		output.close();
		//向客户端反馈上传信息
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
		System.out.println("ssdfsf");
		bw.write("上传成功");
		bw.newLine();
		bw.flush();
		ss.close();
		
	}

}
