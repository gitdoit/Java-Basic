package io;
/*
 * 本类用来演示输出流的初始化以及三个写方法
 * 
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOutputDemo {

	public static void main(String[] args) throws IOException {
		//调用系统资源取创建文件，如果文件已经存在，直接新建FileOutputStream对象指向它。若文件不存在，则新建之后指向它
		FileOutputStream fos = new FileOutputStream("e:\\liujianxin.txtg");
		String str;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一段话");
		str = in.nextLine();
		byte[] bt = str.getBytes();//将字符串转换成字节数组
		byte[] bt1 = {65,66,67,68};
		fos.write(65);//方法一：此方法向文件写入一个ASCII表示的字符
		fos.write(bt);//方法二：字节流只接受字节，所以将字节数组表示的字符串传入该文件
		fos.write(bt1, 1, 3);//方法三：从数组下标为1开始到下标为3结束（1，2，3），写入文件.
		
//		String Chinese = "中华人民共和国";   中文由两个字节表示(一个英文字母、数字一个字节)，计算机通过第一个字节是否为负数来判断这个字符是否是中文
//		byte[] byt2 = Chinese.getBytes(); 如果第一个是负数，那么直接将第二个字节与之拼接形成中文
//		System.out.println(Arrays.toString(byt2));
		
		fos.close();
		//流对象使用完成之后一定要关闭
		//关闭可以通知垃圾回收器回收该对象，并通知系统回收与此文件相关的资源

	}

}
