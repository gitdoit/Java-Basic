package mypraxis;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * ����"32 86 33 73 13 5 54"������������
 * 
 */
public class SplitTest {

	public static void main(String[] args) {
		String src = "32 86 33 73 13 5 54";
		String[] tar = src.split(" ");
		TreeSet<Integer> tree = new TreeSet<>();
		for(String e : tar) {//���ַ���תΪInteger��������
			tree.add(Integer.valueOf(e));
		}
		Iterator it = tree.iterator();
//		while(it.hasNext()) {
//			System.out.print(" "+it.next());
//		}
		System.out.println(tree.toString());
		
		//Ŀ��������TreeSetֱ�ӱȽ��ַ����������򣬵����ַ����ȵ��ǰ�λ�ȵģ����������һ��33 һ�� 5���ַ����ȣ��Ǿ���5��33��
//		TreeSet<String> tree = new TreeSet<>();
//		for(String e : tar) {
//			System.out.println(e.length()+":"+e);
//		}
//		Iterator it = tree.iterator();
//		while(it.hasNext()) {
//			System.out.print(" "+it.next());
//		}
		
	}

}
