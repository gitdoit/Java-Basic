package mypraxis;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {//�����ʺϴ�������ɾ�����ʺϲ���

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("i'am");
		list.add("the");
		list.add("best");
		list.add("man");
		list.add("in");
		list.add("world");
		ListIterator<String> litr = list.listIterator();
		
		List<String> list1 = new LinkedList<>();
		list1.add("������");
		list1.add("��");
		list1.add("������");
		list1.add("��");
		list1.add("˧����");
		ListIterator<String> litr1 = list1.listIterator();
		
		while(litr.hasNext()) {
			if(litr1.hasNext()) {
				litr.add(litr1.next());
			}
			litr.next();
		}
		//System.out.println(list);
		for(String e:list) {
			System.out.print(e);
		}
		
		
	}

}
