package mypraxis;
/*
 * �ҵ�˼·��
 * �ж�ĳ�����Ƿ���ĳ�ļ�������Ҫ���������̵������̡�
 * ��Ϊ��ͬ�ļ����µ��ļ������ļ��в�һ�����Լ���ȶ���ͬ���������뵽�˵ݹ����
 * �������ͼ����ȱ������߹�ȱ�����
 */
import java.io.File;

public class IOTest {

	public static void main(String[] args) {
		File file = new File("e:\\");
		File[] FileArr = file.listFiles();
		DFS(FileArr);
		
	}
	
	public static void DFS(File[] file) {
		for(File e:file) { 
			if(e.isDirectory()) {
				File[] chilFile = e.listFiles();
				if(chilFile != null)
					DFS(chilFile);
			}
			
			else {
				if(e.getName().contains("test.txt")) {
					System.out.println("�����ļ���:"+e.getAbsolutePath());
				}
			}
		}
	}

}

