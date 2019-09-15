package top.seefly.javase.old2017.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 高效缓冲技术，提高IO速度
 * BufferedWriter(OutputStreamWriter )
 * OutputStreamWriter(FileOutputStream)
 * FileOutputStream(File)
 */
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("buffwriter.txt")));
//		BufferedWriter bw1 = new BufferedWriter(new FileWriter("e:\\liujianxin.txt",true));
		String str = "刘建鑫帅";
		bw.write(str);
		bw.write(65);
		bw.newLine();//换行符，根据平台选择换行符，并不单单是 \n
		bw.write(str, 0, 1);
		bw.close();
	}
}
