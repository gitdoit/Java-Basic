package mypraxis;
import java.io.*;
/*
 * 本类用来测试各种读写方法的效率
 * 1，无缓冲区单字节传输	47339毫秒	
 * 2，无缓冲区字节数组传输	101毫秒	
 * 3，有缓冲区单字节传输	374毫秒
 * 4，有缓冲区字节数组传输	25毫秒	
 * 
 */

public class IOTest2 {

	public static void main(String[] args) throws IOException {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		long star = System.currentTimeMillis();
		File src = new File("e:\\学习资料\\10\\avi\\10.01.avi");
		File tar = new File("e:\\copy.avi");
		//bufByOne(src,tar);
		//basicByArr(src,tar);
		bufByOne(src,tar);
		long end = System.currentTimeMillis();
		System.out.println("所用时间："+(end - star)+"毫秒");
	}
	
	public static void basicByOne(File src,File tar) throws IOException {//无缓冲区，单字节传输
		FileInputStream input = new FileInputStream(src);
		FileOutputStream output = new FileOutputStream(tar);
		int temp;
		while((temp = input.read()) != -1)
			output.write(temp);
		input.close();
		output.close();
	}
	
	public static void basicByArr(File src,File tar) throws IOException {//无缓冲区，字节数组传输
		FileInputStream input = new FileInputStream(src);
		FileOutputStream output = new FileOutputStream(tar);
		byte[] bt = new byte[1024];
		int len;
		while((len = input.read(bt)) != -1) {
			output.write(bt, 0, len);
		}
		input.close();
		output.close();
	}
	
	public static void bufByOne(File src,File tar) throws IOException {
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(tar);
		BufferedInputStream input = new BufferedInputStream(in);
		BufferedOutputStream output = new BufferedOutputStream(out);
		
		int temp;
		while((temp = input.read()) != -1)
			output.write(temp);
		input.close();
		output.close();
		
	}
	
	public static void bufByArr(File src,File tar) throws IOException {
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(tar);
		BufferedInputStream input = new BufferedInputStream(in);
		BufferedOutputStream output = new BufferedOutputStream(out);
		
		byte[] bt = new byte[1024];
		int len;
		while((len = input.read(bt)) != -1) {
			output.write(bt, 0, len);
		}
		input.close();
		output.close();
	}
	
	

}
