package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ����������ʾ��һ���ļ�������һ���ļ�д
 */
public class CopyDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("e:\\liujianxin.txt");//�ļ����������쳣
		FileOutputStream fos = new FileOutputStream("e:\\liuyifei.txt");//�ļ����������½�
		
		byte[] byt = new byte[1024];//�����ı���ʾ
//		while(fis.read(byt) > 0) ���ַ������ƻ������һ�θ��Ƶ�ʱ���������û����������ô�Ὣ�ո�Ҳ���ƽ�ȥ��
//			fos.write(byt);
		int len;
		while((len = fis.read(byt)) != -1)
			fos.write(byt,0,len);//ʹ�����ַ�����ÿ�ζ��ǽ��������е�����д�룬�յĲ�д
		fis.close();
		fos.close();
		
//		FileInputStream fis1 = new FileInputStream("e:\\laopogif.gif");//�ֽ�������ͼƬ
//		FileOutputStream fos1 = new FileOutputStream("e:\\laopofuben.gif");
//		while(fis1.read(byt) != -1)
//			fos1.write(byt);
//		fis1.close();
//		fos1.close();
		
		//������ƵҲ��һ�����̣�������
	}

}
 