package top.seefly.javase.old2017.extendspackage;
/*
 * 该类用来演示instanceof的用法
 * 
 * 1.实例 instanceof 类/接口
 * 用来判断前面的实例是否与后面的类有线性继承关系，或是接口实现。
 * 若实例是类的祖先则返回false，否则返回true
 * 当实例与类没有线性继承关系时候，像是String类的实例与Math做比较，那么将会编译失败
 * */
public class InstanceofDemo {

	public static void main(String[] args) {
		//虽然声明类型为Object，但是instanceof比较的是实际类型。则返回的是ture
		Object str = new String();
		System.out.println(str instanceof String);
		
		//true
		System.out.println(str instanceof Object);
		//str的实际类型是String并且它实现了Comparable接口，所以返回的是ture
		System.out.println(str instanceof Comparable);
		
		//虽然当实例与类没有继承或者实现关系时会编译错误，但是这里的声明类型为Object在编译时会骗过编译器。结果返回false
		System.out.println(str instanceof Math);
		
		String s = "Hello";
		//System.out.println(s instanceof Math);编译失败

	}

}
