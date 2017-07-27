package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("writer.txt");//默认不追加，覆盖
		//FileWriter fw1  = new FileWriter("writer.txt",true);指定可追加
		char[] ch = {'d','d'};
		fw.write("liu");
		fw.write(65);
		fw.write(ch);
		fw.close();
	}
}
