package regex;
/*
 * ���ո�����������ʽ���������ַ�����ֳ�n���ַ�����������һ���ַ�������
 * 
 */
import java.util.Arrays;

public class SplitDemo {
	
	public static void main(String[] args) {
		String knights = "Then,when you have found the shrubbery,you must "
				+ "cut down the mightiest tree int hte forest..."
				+ "with..a herring!";
		String[] str = knights.split(" ");//���ո�ʽ�з�,
		
		String condition = "18-24";
		String[] str1 = condition.split("-");
		
		
		String src = "liu    jian    xin";
		String[] str2 = src.split(" ");//��һ���ո�ʽ�����з�
		for(int i = 0;i < str2.length ; i++) {
			System.out.println(i+":"+str2[i]);
		}
		
		String[] str3 = src.split(" +");//��һ�������ո�ʽ�з�
		for(String e : str3) {
			System.out.println(e);
		}
		
		String src1 = "E:\\ѧϰ����\\����\\avi";
		String[] str4 = src1.split("\\\\");//ע�⣬java�е�\����ת�����˼��\\�����������Ϊ��'\'������'\\'Ӧ����\\\\��ʾ
		for(String e : str4) {
			System.out.println(e);
		}
	
	}

}
