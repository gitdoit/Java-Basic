package collection;
/*
 * �������������ݽṹ���ƣ���������ʱ������
 * ��Ϊ��Ҫ����������ҪԪ�����;��пɱ��ԡ�
 * �����������Ԫ�ز��ɱȣ�����û��ʵ��comparable�ӿڣ�������û��Ϊ������ָ���Ƚ�������ô�ᱨ��
 * 
 * �Զ����������Ҫʹ������������ôҪʵ��comparable�ӿڣ�����Ҫ��дtoString����(��ӡ����ʱ���ã�����ʹ�ӡ��ַ)��
 * �Լ���������ð�hashCoed,equals,toString������������д��
 * */
import java.util.*;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Item>  it = new TreeSet<>();
		it.add(new Item("liuC",1));
		it.add(new Item("liuB",2));
		it.add(new Item("liuA",3));
		
		TreeSet<Item> it1 = new TreeSet<>(new Comparator<Item>() {//ʵ�����ڲ������࣬Ϊ������ָ���Ƚ���
			@Override
			public int compare(Item o1, Item o2) {//ʵ�ֱȽϷ������˷�����Item�����Դ��ıȽ������ȵĶ�����ͬ
				String str1 = o1.getName();
				String str2 = o2.getName();
				return str1.compareTo(str2);
			}
		});
		
		it1.add(new Item("liuC",1));
		it1.add(new Item("liuB",2));
		it1.add(new Item("liuA",3));
		//it1.addAll(it);����֮�佫Collection������ӣ����Զ�����
		
		System.out.println(it);//��id
		System.out.println(it1);//������
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