package extendspackage;
/*
 * 初始化块
 * 与构造方法类似，但优先与构造方法前执行，且会沿着继承链像构造方法一样去执行。
 * 它不能接收任何参数，且总是隐式执行的。
 * 每一次调用构造方法(有参无参)之前都会执行普通初始化块，但静态初始化块只在该类加载的时候执行一次，且仅一次。像是类变量
 * 
 * 静态初始化块，在虚拟机加载该类时会执行该块，且只执行一次。
 * */
public class Demo2 {

	public static void main(String[] args) {
		new Leaf();
		new Leaf();//实例化两个对象，但是所有静态块只加载执行一次

	}

}

class Root{
	static {
		System.out.println("Root的静态初始化块");
	}
	{
		System.out.println("Root的普通初始化块");
	}
	public Root() {
		System.out.println("Root的无参构造方法");
	}
}
class Mid extends Root{
	static {
		System.out.println("Mid的静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid() {
		System.out.println("Mid的无参构造方法");
	}
	public Mid(String msg) {
		this();
		System.out.println("Mid的有参构造方法，其参数值为:"+msg);
	}	
}

class Leaf extends Mid{
	static {
		System.out.println("Leaf的静态初始化块");
	}
	{
		System.out.println("Leaf的普通初始化块");
	}
	public Leaf() {
		super("测试测试");
		System.out.println("Leaf的无参构造方法");
	}
}