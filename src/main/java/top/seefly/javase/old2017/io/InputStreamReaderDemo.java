package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException{
		InputStreamReader read = new InputStreamReader(new FileInputStream("writer.txt"),"UTF-8");
		char[] cr = new char[1024];
		int len;
		while((len = read.read(cr)) != -1) {//一次读一个字符数组长度的内容
			System.out.println(cr);			//int read()一个读取一个字符
		}
		char cc;
		read.close();
		
		
	}

}
