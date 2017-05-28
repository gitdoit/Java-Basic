package arraypackage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����������ʾAPI�е�ArrayList���ʹ�÷���
 * ArrayList�������洢 ���� ��һ���б�
 * һ���б���ֻ�ܴ洢��ͬ���͵Ķ���
 * �����ڶ����ʱ��һ���Խ����ж�������б��ڣ����߶���֮��ִ����
 * java.util.Collections�Ĳ���������ArrayList���ͱ���,���߿��Խ���������ת��Ϊ�б� Arrays.asList(��������);
 * 
 * ArrayList��ʹ�÷���
 * ***********
 * add(o:E) void
 * add(index:int,o:E) void
 * clear():void
 * contains(o:Object):boolean
 * get(index:int):E
 * indexOf(o:Object):int
 * isEmpty():boolean
 * lastIndexOf(o:Object):int �����б��������ָö�����±�
 * remove(o:Object):boolean
 * size():int
 * remove(index:int):E
 * set(index:int,o:E):E
 * */
public class ArrayListDemo {
	public static void main(String[] args){
	String[] arr = {"A","B","A","A"};
	ArrayList<String> list = new ArrayList<>();
	ArrayList<String> list1 = new ArrayList<>(Arrays.asList(arr));
	//���ַ�������ת��Ϊ�б���ArrayList�Ĺ��췽�����ڴ���һ��ArrayList�����ַ������鵽ArrayList
	list.add("A");
	list.add("B");
	list.add("A");
	list.add("A");
	//��δ���������list1��Ч����һ����
	
	list.toArray(arr);
	//��ArrayList���ַ������飬��list�е����ݸ��Ƶ�arr��
	
	java.util.Collections.sort(list);
	//����б��е�Ԫ���ǿɱȵ���ô�����������б��е�Ԫ�ؽ�������
	System.out.println(list);
	
	System.out.println(java.util.Collections.max(list));
	//�õ�һ���б�������Ԫ��
	
	java.util.Collections.shuffle(list);
	System.out.println(list);
	//�����б��е�Ԫ��,Collections�еĸ��ַ��������������飬��Ҫʹ�ô����еķ�������Ҫת��Ϊ�б�Arrays.asList(a)
	
	Integer[] a = {1,2,3,4,5,6};
	ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(a));
	System.out.println(java.util.Collections.max(aList));
	System.out.println(java.util.Collections.max(Arrays.asList(a)));
	//��ʾ��Collections������ʹ�÷�������һ����Ҫ�����б��ڶ��ָ�Ϊ����
	}
}
