package collection;
/*
 * list�е�retainAll�����ĺ����ǵ��ô˷����ļ����Ƿ��뷽�������еļ����н���
 * ����У���������߼��ϵ��ڸý�����������true����ζ�ŵ����߼��Ϸ����˸ı䣩.
 * ���޽�������������߼���Ϊ�ռ�����Ϊ���ǵĽ���Ϊ�ռ�����������true
 * 
 * �������߱�����ǲ������ϵ��Ӽ�����ô�����߼��ϲ��ᷢ���κθı䣬�ҷ���false��
 * 
 * */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetainDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		
		list.add("java");
		list.add("hello");
		list.add("world");
		
		list1.addAll(list);
		list1.add("see");
		System.out.println("list:"+list);
		System.out.println("list1:"+list1);
		System.out.println("list1 contains see:"+list1.contains("see"));
		System.out.println("list1 retainAll list:"+list1.retainAll(list));
		System.out.println("after list1.retainAll(list),the list1 now is:"+list1);
		System.out.println("again useing retainAll(list):"+list1.retainAll(list));
		
		
	}
}
