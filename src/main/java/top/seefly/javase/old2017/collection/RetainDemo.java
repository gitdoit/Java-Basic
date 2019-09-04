package collection;
/*
 * list中的retainAll方法的含义是调用此方法的集合是否与方法参数中的集合有交集
 * 如果有，则领调用者集合等于该交集，并返回true（意味着调用者集合发生了改变）.
 * 若无交集，则领调用者集合为空集（因为他们的交集为空集）。并返回true
 * 
 * 若调用者本身就是参数集合的子集，那么调用者集合不会发生任何改变，且返回false。
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
