package top.seefly.javase.old2017.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("buffwriter.txt")));
		BufferedReader br1 = new BufferedReader(new FileReader("e:\\liujianxin.txt"));
//		char[] ch = new char[1024];
//		while(br.read(ch) != -1) {
//			System.out.println(ch);
//		}
//		br.close();
		
		String str;
		while((str = br.readLine()) != null) {//一次读取一行，读到末尾返回null
			System.out.println(str);
		}
		
		while((str = br1.readLine()) != null)
			System.out.println(str);
	}

}
