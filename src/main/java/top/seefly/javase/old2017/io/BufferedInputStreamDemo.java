package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class BufferedInputStreamDemo {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("e:\\liujianxin.txt"));
		byte[] bt = new byte[8];//��Ȼʹ���˻���أ���ҲҪΪ�ײ�����ṩһ����������
//		while(bfis.read(bt) != -1)
//			System.out.println(new String(bt));
		int by;
		while((by = bfis.read()) != -1)
			System.out.println((char)by + ":" + by);
		bfis.close();

	}

}
