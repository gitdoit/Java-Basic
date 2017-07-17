package collection;
/*
 * 排序树，和数据结构类似，都是排序时建树。
 * 因为需要排序，所以需要元素类型具有可比性。
 * 如果排序树中元素不可比（该类没有实现comparable接口），并且没有为排序树指定比较器。那么会报错
 * 
 * 自定义类如果想要使用排序树，那么要实现comparable接口，并且要复写toString方法(打印树的时候用，否则就打印地址)。
 * 自己定义类最好把hashCoed,equals,toString三个方法都重写。
 * */
import java.util.*;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Item>  it = new TreeSet<>();
		it.add(new Item("liuC",1));
		it.add(new Item("liuB",2));
		it.add(new Item("liuA",3));
		
		TreeSet<Item> it1 = new TreeSet<>(new Comparator<Item>() {//实例化内部匿名类，为排序树指定比较器
			@Override
			public int compare(Item o1, Item o2) {//实现比较方法，此方法与Item类型自带的比较器所比的东西不同
				String str1 = o1.getName();
				String str2 = o2.getName();
				return str1.compareTo(str2);
			}
		});
		
		it1.add(new Item("liuC",1));
		it1.add(new Item("liuB",2));
		it1.add(new Item("liuA",3));
		//it1.addAll(it);可以之间将Collection对象添加，会自动有序化
		
		System.out.println(it);//比id
		System.out.println(it1);//比名字
	}
}

class Item implements Comparable<Item> {
	private String name;
	private int id;
	
	public Item() {
		this("", 0);
	}
	public Item(String name,int id) {
		this.id = id;
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public int compareTo(Item o) {
		return this.id - o.id;
	}
	@Override
	public String toString() {
		 
		return String.format("|name=%s,id=%d|",this.name,this.id);
	}
	
	
}