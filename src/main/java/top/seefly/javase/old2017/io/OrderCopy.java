package io;
/*
 * 
 * 将指定文件夹内所有符合条件的文件更名复制到另一个指定文件夹内。
 */
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OrderCopy {

	public static void main(String[] args) throws IOException{
		
		File file = new File("e:\\");
		File[] fileArr = file.listFiles(new FileFilter() {//匿名内部过滤器，取出符合条件的File
			@Override
			public boolean accept(File pathname) {
				if(!pathname.isDirectory())//不是文件夹
					if(pathname.getName().endsWith(".java"))//文件名结尾为.java
						return true;
				return false;
			}
		});
		String newName = null;
		//int len;
		byte[] bt = new byte[1024];//按字节传输
		int btlen;
		for(File e : fileArr) {//遍历数组
			//len = e.getName().length();
			//newName = e.getName().substring(0,len-5);//从这里看出，对每种类的方法了解是多么重要！！这里有一个replaceAll可以减少很多操作
			newName = e.getName().replaceAll(".java", ".jad");//设置新名称
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
