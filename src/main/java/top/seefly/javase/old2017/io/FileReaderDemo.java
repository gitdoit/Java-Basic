package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader frd = new FileReader(new File("writer.txt"));
		char[] ch = new char[1024];
		while(frd.read(ch) != -1) {
			System.out.println(ch);//�����޷�ָ�����뷽ʽ��ʹ�õ���Ĭ�ϵ�GBK����Դ�ļ���ͨ��UTF-8����ġ����Գ�������
		}
		frd.close();
	}

}
