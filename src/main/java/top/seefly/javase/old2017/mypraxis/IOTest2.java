package mypraxis;
import java.io.*;
/*
 * �����������Ը��ֶ�д������Ч��
 * 1���޻��������ֽڴ���	47339����	
 * 2���޻������ֽ����鴫��	101����	
 * 3���л��������ֽڴ���	374����
 * 4���л������ֽ����鴫��	25����	
 * 
 */

public class IOTest2 {

	public static void main(String[] args) throws IOException {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		long star = System.currentTimeMillis();
		File src = new File("e:\\ѧϰ����\\10\\avi\\10.01.avi");
		File tar = new File("e:\\copy.avi");
		//bufByOne(src,tar);
		//basicByArr(src,tar);
		bufByOne(src,tar);
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(end - star)+"����");
	}
	
	public static void basicByOne(File src,File tar) throws IOException {//�޻����������ֽڴ���
		FileInputStream input = new FileInputStream(src);
		FileOutputStream output = new FileOutputStream(tar);
		int temp;
		while((temp = input.read()) != -1)
			output.write(temp);
		input.close();
		output.close();
	}
	
	public static void basicByArr(File src,File tar) throws IOException {//�޻��������ֽ����鴫��
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
