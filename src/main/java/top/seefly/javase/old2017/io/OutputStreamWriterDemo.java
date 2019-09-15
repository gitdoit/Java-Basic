package top.seefly.javase.old2017.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 字符输出流
 * Object
 * 		Writer
 * 			OutputStreamWriter
 * 				FileWriter
 * 
 * public void writer(int chr)写一个字符
 * public void writer(char[] chr)写一个字符数组
 * public void writer(char[],starIndex,len) 指定位置即长度写出字符数组的某部分
 * public void writer(String str)写一个字符串
 * public void writer(Sting str,int starIndex,len)指定位置即长度写出字符串的某部分
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		OutputStreamWriter wtr = new OutputStreamWriter( new FileOutputStream("e:\\writer.txt"));//这里使用默认编码GBK
//		OutputStreamWriter wtr1 = new OutputStreamWriter(new FileOutputStream("writer.txt"),"UTF-8");//这里指定编码，文件在本项目目录下
		char[] c = {'s','b','c','刘'};
		String str = "|Sting参数|";
//		wtr1.write("UTF-8编码测试");	//两个字符输出流对象对一个文件进行操作，他们都不会检查源文件中是否有内容，都是从开头写入。
									//同理，两个字符输入流对同一个文件操作，都是同文件开头读入
//		wtr1.flush();可主动将缓冲池内数据刷新，但close方法可以完成这个动作
//		wtr1.close();//向文件中写数据，此方法的含义是刷新缓冲池（即将缓冲池的内容冲入文件内），并关闭相关系统资源。
		
		wtr.write(str);//|Sting参数|
		wtr.write(str, 6, 2);//|Sting参数|参数
		wtr.write(c);//|Sting参数|参数abc刘
		wtr.write(c, 3, 1);//|Sting参数|参数sbc刘刘
		wtr.close();
		
	}
}
