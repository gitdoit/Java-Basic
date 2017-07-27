package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * ��Ч���弼�������IO�ٶ�
 * BufferedWriter(OutputStreamWriter )
 * OutputStreamWriter(FileOutputStream)
 * FileOutputStream(File)
 */
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("buffwriter.txt")));
//		BufferedWriter bw1 = new BufferedWriter(new FileWriter("e:\\liujianxin.txt",true));
		String str = "������˧";
		bw.write(str);
		bw.write(65);
		bw.newLine();//���з�������ƽ̨ѡ���з������������� \n
		bw.write(str, 0, 1);
		bw.close();
	}
}
