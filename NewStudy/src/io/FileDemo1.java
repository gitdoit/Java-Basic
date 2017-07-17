package io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/*
 * ����������ʾFile����Ĵ������Լ��ļ��к��ļ��Ĵ���
 * File:�ļ���Ŀ¼·���ĳ����ʾ��ʽ
 * ���췽��
 *	File(String pathname)  ����·�����õ�һ��Fild����
 * 	File(String parent, String child) ����һ���ļ���·�������ļ����ڵ��ļ����ļ��еõ�һ��Fil����
 * 	File(File parent, String child) ����Fil����ʹ˶�������ļ���Ŀ¼�õ�Fil����
 *	�½�File���󲢲�����Ӳ���ϴ�����Ӧ���ļ����ļ��У���ֻ���ļ����ļ���·���ĳ����ʾ��ʽ����һ��File�������Ƕ���ķ�װ
 *	
 *	creatNewFile() ��������File�����Ӧ��[�ļ�]������ļ��Ѿ����ڣ���ô����false������true���÷������׳�IOException
 *	
 */
public class FileDemo1 {

	public static void main(String[] args) throws IOException {
//		File file = new File("e:\\git");
//		File file1 = new File("e:\\git","a.txt");
//		File file2 = new File(file,"b.txt");
//		File file3 = new File("e:\\git\\mkdirs\\test");
//		File file4 = new File("file.txt");//�������������·������ô���ڵ�ǰ�����ռ��ڵı���Ŀ�ļ����ڴ���
//		
//		System.out.println("File�����Ƿ����-file1.exists:"+file1.exists());//File�����Ӧ���ļ����ļ����Ƿ���ڣ�����true
//		System.out.println("�����ļ���-file1.mkdir:"+file1.mkdir());//��������[�ļ���]������ʹ�ô˷��������ļ���ʹ��·����a.txt�����ᴴ����������ļ��С������ɹ�����true
//		System.out.println("�����ļ�-file2.createNewFile:"+file2.createNewFile());//���ļ�����Ŀ¼�����������쳣�����������ļ����ɹ�����true
//		System.out.println("�����ļ���-file3.mkdirs:"+file3.mkdirs());//�����ļ��У���������ļ��и�Ŀ¼�����ڣ����Զ������������ɹ�����true
//		System.out.println("���·������-file4.createNewFile:"+file4.createNewFile());//���ļ�������e://workspace//NewStudy
//		System.out.println("�õ�����·��-file4.getAbsolutePath:"+file4.getAbsolutePath());//�õ�����·��
//		System.out.println("ɾ��-file4.delete:"+file4.delete());//ɾ����java�е�ɾ������������ʹ�ļ����ļ��г����ڻ���վ
//		//System.out.println("ɾ��mkdirs-file3.delete:"+file3.delete());
//		System.out.println("ɾ��mkdirs-file3.delete:"+new File("mkdirs").delete());//����ļ��зǿգ����޷�ֱ��ɾ��
//		
//		File file6 = new File("yy.txt");
//		file6.createNewFile();
//		File tmpFile = new File("qq.txt");
//		file6.renameTo(tmpFile);//renameTo���β���File���͵ģ����·����ͬ����ôֱ��ʹ���βε����ơ�������β�·����ͬ����ô�ǽ��ļ����е��β�·��������
//		
		File file7 = new File("e:\\ѧϰ����");
		System.out.println(file7.exists());
		String[] list = file7.list();//���ظ�Ŀ¼�����е��ļ����Լ��ļ����ƣ����ַ������鷵��
		for(String e:list)
			System.out.println(e);
		String[] list1 = file7.list(new FilenameFilter() {//��file7�ļ�������������File�������list1����
			@Override
			public boolean accept(File dir, String name) {
				//�ж�����
				return false;
			}
		});
		//File[] fileArr1 = file7.listFiles();��file7�µ�����file������file������ʽ���أ��������ж�
		File[] fileArr = file7.listFiles(new FileFilter() {//�����жϣ����ظ�Ŀ¼����������������File����
			@Override
			public boolean accept(File f) {//FileFIlter��һ���ӿڣ��ӿ��ڵ�accept���������ж�file7�ļ���������������file���󡣲�
											//�����������Ķ������File����
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
