package mypraxis;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {//����չ���飬�ײ�������ʵ�֣��̲߳���ȫ��Ч�ʸߡ��ʺ�������ʣ����ʺϲ���ɾ����

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("is");
		list.add("good");
		
		ListIterator<String> itr = list.listIterator();
		
		String str;
		while(itr.hasNext()) {
			str = itr.next();
			if(str != null && str.equals("good"))
				itr.add("javaee");
		}
		System.out.println(list);
	}

}
