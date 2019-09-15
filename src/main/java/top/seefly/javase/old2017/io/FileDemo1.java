package top.seefly.javase.old2017.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/*
 * 本类用来演示File对象的创建，以及文件夹和文件的创建
 * File:文件和目录路径的抽象表示形式
 * 构造方法
 *	File(String pathname)  根据路径名得到一个Fild对象
 * 	File(String parent, String child) 根据一个文件夹路径，和文件夹内的文件或文件夹得到一个Fil对象
 * 	File(File parent, String child) 根据Fil对象和此对象的子文件或目录得到Fil对象
 *	新建File对象并不会在硬盘上创建对应的文件或文件夹，它只是文件或文件夹路径的抽象表示形式，而一个File对象则是对其的封装
 *	
 *	creatNewFile() 用来创建File对象对应的[文件]，如果文件已经存在，那么返回false，否则true。该方法会抛出IOException
 *	
 */
public class FileDemo1 {

	public static void main(String[] args) throws IOException {
//		File file = new File("e:\\git");
//		File file1 = new File("e:\\git","a.txt");
//		File file2 = new File(file,"b.txt");
//		File file3 = new File("e:\\git\\mkdirs\\test");
//		File file4 = new File("file.txt");//如果不给出绝对路径，那么会在当前工作空间内的本项目文件夹内创建
//		
//		System.out.println("File对象是否存在-file1.exists:"+file1.exists());//File对象对应的文件或文件夹是否存在，存在true
//		System.out.println("创建文件夹-file1.mkdir:"+file1.mkdir());//创建的是[文件夹]，不能使用此方法创建文件即使子路径是a.txt，它会创建这个名的文件夹。创建成功返回true
//		System.out.println("创建文件-file2.createNewFile:"+file2.createNewFile());//若文件所属目录不存在则抛异常，用来创建文件，成功返回true
//		System.out.println("创建文件夹-file3.mkdirs:"+file3.mkdirs());//创建文件夹，如果所创文件夹父目录不存在，则自动创建。创建成功返回true
//		System.out.println("相对路径创建-file4.createNewFile:"+file4.createNewFile());//此文件创建在e://workspace//NewStudy
//		System.out.println("得到绝对路径-file4.getAbsolutePath:"+file4.getAbsolutePath());//得到绝对路径
//		System.out.println("删除-file4.delete:"+file4.delete());//删除，java中的删除操作，不会使文件或文件夹出现在回收站
//		//System.out.println("删除mkdirs-file3.delete:"+file3.delete());
//		System.out.println("删除mkdirs-file3.delete:"+new File("mkdirs").delete());//如果文件夹非空，则无法直接删除
//		
//		File file6 = new File("yy.txt");
//		file6.createNewFile();
//		File tmpFile = new File("qq.txt");
//		file6.renameTo(tmpFile);//renameTo的形参是File类型的，如果路径相同，那么直接使用形参的名称。如果和形参路径不同，那么是将文件剪切到形参路径并改名
//		
		File file7 = new File("e:\\学习资料");
		System.out.println(file7.exists());
		String[] list = file7.list();//返回该目录下所有的文件夹以及文件名称，以字符串数组返回
		for(String e:list)
			System.out.println(e);
		String[] list1 = file7.list(new FilenameFilter() {//将file7文件夹中满条件的File对象放入list1数组
			@Override
			public boolean accept(File dir, String name) {
				//判断条件
				return false;
			}
		});
		//File[] fileArr1 = file7.listFiles();将file7下的所有file对象以file数组形式返回，不经过判断
		File[] fileArr = file7.listFiles(new FileFilter() {//经过判断，返回该目录下所有满足条件的File对象
			@Override
			public boolean accept(File f) {//FileFIlter是一个接口，接口内的accept方法用来判断file7文件夹内满足条件的file对象。并
											//并满足条件的对象放入File数组
				if(f.isDirectory() && f.getName().equals("day16"))
					return true;
				else
					return false;
			}
		});
		for(File e : fileArr) {
			System.out.println(e.getName());
		}
//		for(File e:fileArr)
//			System.out.println(e.getName());
		
//		File file = new File("e:\\git\\b.txt");
//		System.out.println(file.isFile());
		
		
		
	}

}
