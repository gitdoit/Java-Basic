package mypraxis;

import java.io.File;

/*
 * ��ĳ�ļ��������������������ļ�������
 */
public class IOTest1 {

	public static void main(String[] args) {
//			File file = new File("e:\\ѧϰ����");
//			File[] fileArr = file.listFiles();
//			String[] name = file.list();
//			int i = 1;
//			for(File e : fileArr) {
//				e.renameTo(new File(file,"��Ƶ"+ i++));
//			}
		
		File file = new File("e:\\ѧϰ����");
		File[] fileArr = file.listFiles();//���ļ���Ŀ¼�б�
		for(int i = 0; i < fileArr.length; i++) {//�����������ļ���
			File[] chaiFile = fileArr[i].listFiles();//ȡ�����ļ����������ļ�
			 File[] ccFile = chaiFile[0].listFiles();//��ȡ���ļ����е�һ���ļ��������ļ�
			 String name = ccFile[0].getName().substring(0,2);//��ȡ���ļ����е�һ���ļ�����ǰ�����ַ�
			fileArr[i].renameTo(new File(file,name));
			//System.out.println(new File(file,name).getAbsolutePath());
			
		}

	}

}
