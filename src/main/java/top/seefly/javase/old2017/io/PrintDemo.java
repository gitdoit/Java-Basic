package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 * 打印流：
 * 	printStream 字节打印流
 * 	printWrite	字符打印流
 * 			这两个类基本上是可以混用的，唯一的差别就是一个可以写字节，一个不能。也就是说printStream更吊一点，可以写字节和字符。另一个只能写字节
 * 			方法都差不多。
 * 	
 * 	打印流的特点：
 * 			只有写数据，没有读数据。只能操作目的地，不能操作数据源。
 * 			可以操作任意的数据类型
 * 			如果启动了自动刷新，能够自动刷新
 * 			该流可以直接操作文本文件
 */
public class PrintDemo {

	public static void main(String[] args) throws IOException{
		
		PrintStream ps = new PrintStream(new FileOutputStream("wirter.txt"),true);//可以实现自动刷新，但要调用带ln或f的方法
		ps.print("刘建鑫");//此方法没有ln，不刷新
		ps.println(true);//写入boolean值，并刷新，下面不用调用close或flush进行冲刷
		ps.close();
		
		PrintWriter pw = new PrintWriter(new FileOutputStream("wirter.txt",true));//不指定自动冲刷,但设置追加。否则上面写的就没了
		pw.write(65);// 原版的wirte方法只能写字符或字符数组或字符串,此行写入ASCII为65的字符
		pw.print(65);//此行写入65
		pw.print(true);//而新的print方法可以写任意数据类型。
		pw.close();
	}

}
