package mypraxis;

import java.io.File;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

/*
 * ���⣺��ָ���ļ��ڵ����дʻ��г��*
 * ˼·�����дʻ㳤�Ȳ��̶������ݲ��̶���������ѭ��ƥ����Ч�ʼ��͡�
 * ���дʻ�¼�����дʻ�⣬����ô���ַ�����׼ȷ�ҵ����дʻ��أ�
 * �Ҿ��ÿ���ʹ�ö༶ӳ�䣡
 * 		һ��ӳ�䣺�洢���е������ַ���ʹ��HashSet
 * 		����ӳ�䣺�洢���е��ʳ���Ϊ2,��������дʵ�ǰ�����ַ�.ʹ��HashSet
 * 		����ӳ�䣺�洢���е��ʳ���Ϊ3�ĵ��ʣ�����ֻ�������е��ʳ������Ϊ3��ʹ��HashSet
 * ���������жϸ����ַ�������һ��ӳ�䡣��Ϊ���е������ַ�������ַ�����ȡ�Ӵ��ַ���ʼ�������ַ����ж���ӳ�䡣���ޣ����������������������ӳ�䡣����ӳ�����ޣ�������
 * �������ַ��������������������ַ���
 * �����ҿ���һ���˳���ţ�ƣ��Ҳ�����ģ���ô��ôţ�ƣ�ϰ��ƽ���˶�����ţ�ƵĲ��У������������Ìţ�ţ��
 */
public class HexieTest {

	public static void main(String[] args) throws IOException {
		double startima = System.currentTimeMillis();
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\IOTest\\src.txt")));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\IOTest\\tar.txt")));
		BufferedReader input1 = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\IOTest\\���дʿ�.txt")));
		StringBuffer words = new StringBuffer();
		String str1 = null;
		while((str1=input.readLine()) != null) {//���Ƚ��ļ������words��������
			words.append(str1);
		}
		//System.out.println(words);
		input.close();
		HashSet<String> base = new HashSet<>();
		HashSet<String> mid = new HashSet<>();
		HashSet<Character> top = new HashSet<>();
		//¼�����дʻ㣬�˲���ӦΪ�û����������ƹ��ܺ������������
//		base.add("ţ��");
//		base.add("ɵ��");
//		base.add("������");
//		base.add("ϰ��ƽ");
//		base.add("������");
		while((str1 = input1.readLine()) != null){//���дʿ����base
			base.add(str1);
		}
		
		//��ȡ���дʻ����ַ���ǰ�����ַ����˲���ӦΪ�Զ�����
		Iterator<String> it = base.iterator();
		String str = null;
		while(it.hasNext()) {
			str = it.next();
			top.add(str.charAt(0));
			mid.add(str.substring(0, 2));
		}
		//System.out.println(mid);
		//�����ַ���
		int index;
		for(index = 0; index < words.length();index++) {//��Ҫ���޸ģ�
			if(top.contains(words.charAt(index)) && index < words.length() - 1) {//�������Ҳ������һ���ַ�
				if(mid.contains(words.substring(index,index+2))) {
					if(index < words.length() - 2 && base.contains(words.substring(index,index+3))) {
						words.replace(index, index+3, "***");
					}
					else {
						words.replace(index, index+2, "**");
					}
				}
			}
				
		}
		String str2 = words.toString();
		output.write(str2);
		output.close();
		System.out.println(System.currentTimeMillis() - startima);
		
		
	}

}
