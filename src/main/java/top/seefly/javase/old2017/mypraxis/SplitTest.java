package top.seefly.javase.old2017.mypraxis;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 将："32 86 33 73 13 5 54"进行升序排序
 * 
 */
public class SplitTest {

	public static void main(String[] args) {
		String src = "32 86 33 73 13 5 54";
		String[] tar = src.split(" ");
		TreeSet<Integer> tree = new TreeSet<>();
		for(String e : tar) {//将字符串转为Integer进行排序
			tree.add(Integer.valueOf(e));
		}
		Iterator it = tree.iterator();
//		while(it.hasNext()) {
//			System.out.print(" "+it.next());
//		}
		System.out.println(tree.toString());
		
		//目的是想用TreeSet直接比较字符串进行排序，但是字符串比的是按位比的，如果两个数一个33 一个 5用字符串比，那就是5比33大
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
