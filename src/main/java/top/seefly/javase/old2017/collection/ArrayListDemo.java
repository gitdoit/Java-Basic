package top.seefly.javase.old2017.collection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 该类用来演示API中的ArrayList类的使用方法
 * ArrayList是用来存储 对象 的一个列表！
 * 一个列表内只能存储相同类型的对象
 * 可以在定义的时候一次性将所有对象放在列表内，或者定义之后分次添加
 * java.util.Collections的操作对象是ArrayList类型变量,或者可以将对象数据转换为列表 Arrays.asList(对象数组);
 * 
 * ArrayList的使用方法
 * ***********
 * add(o:E) void
 * add(index:int,o:E) void
 * clear():void
 * contains(o:Object):boolean
 * get(index:int):E
 * indexOf(o:Object):int
 * isEmpty():boolean
 * lastIndexOf(o:Object):int 返回列表中最后出现该对象的下标
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
	//将字符串数组转化为列表传给ArrayList的构造方法用于创建一个ArrayList。从字符串数组到ArrayList
	list.add("A");
	list.add("B");
	list.add("A");
	list.add("A");
	//这段代码跟上面的list1的效果是一样的
	
	list.toArray(arr);
	//从ArrayList到字符串数组，将list中的内容复制到arr里
	
	java.util.Collections.sort(list);
	//如果列表中的元素是可比的那么这个方法会对列表中的元素进行排序
	System.out.println(list);
	
	System.out.println(java.util.Collections.max(list));
	//得到一个列表中最大的元素
	
	java.util.Collections.shuffle(list);
	System.out.println(list);
	//打乱列表中的元素,Collections中的各种方法不适用于数组，若要使用此类中的方法，需要转化为列表Arrays.asList(a)
	
	Integer[] a = {1,2,3,4,5,6};
	ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(a));
	System.out.println(java.util.Collections.max(aList));
	System.out.println(java.util.Collections.max(Arrays.asList(a)));
	//演示了Collections的两种使用方法，第一种需要创建列表，第二种更为方便
	ArrayList<Double> num = new ArrayList<>();
	
	
	}
}
