package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("writer.txt");
		char[] ch = {'d','d'};
		fw.write("liu");
		fw.write(65);
		fw.write(ch);
		fw.close();
	}
}
