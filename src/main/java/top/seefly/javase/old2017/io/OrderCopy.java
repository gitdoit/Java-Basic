package io;
/*
 * 
 * ��ָ���ļ��������з����������ļ��������Ƶ���һ��ָ���ļ����ڡ�
 */
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OrderCopy {

	public static void main(String[] args) throws IOException{
		
		File file = new File("e:\\");
		File[] fileArr = file.listFiles(new FileFilter() {//�����ڲ���������ȡ������������File
			@Override
			public boolean accept(File pathname) {
				if(!pathname.isDirectory())//�����ļ���
					if(pathname.getName().endsWith(".java"))//�ļ�����βΪ.java
						return true;
				return false;
			}
		});
		String newName = null;
		//int len;
		byte[] bt = new byte[1024];//���ֽڴ���
		int btlen;
		for(File e : fileArr) {//��������
			//len = e.getName().length();
			//newName = e.getName().substring(0,len-5);//�����￴������ÿ����ķ����˽��Ƕ�ô��Ҫ����������һ��replaceAll���Լ��ٺܶ����
			newName = e.getName().replaceAll(".java", ".jad");//����������
			FileInputStream in = new FileInputStream(e);
			FileOutputStream out = new FileOutputStream("e:\\A\\"+newName);
			while((btlen = in.read(bt)) != -1) {
				out.write(bt, 0, btlen);
			}
			in.close();
			out.close();
		}
		
	}

}
