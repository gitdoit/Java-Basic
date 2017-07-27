package extendspackage;
/*
 * 在实例化子类时会根据构造链去先构造父类
 * 若父类中的方法被子类覆盖，且在父类构造函数中使用了这个方法。此时有可能出错！
 * 
 * 防止父类被继承的方式有两种。
 * 1，父类被修饰为final，即最终的。则无法被修改与继承
 * 2，父类中的构造方法都被修饰为private
 * */
public class Demo1 {

	public static void main(String[] args) {
		Sub a = new Sub();
		
	}

}

class Base{
	public Base() {//在子类实例化时先构造父类
		test();
	}
	public void test() {//子类覆盖了这个方法，所以父类中的构造方法调用的不再是这个方法
		System.out.println("父类test方法");
	}
}

class Sub extends Base{
	private String name;
	public Sub() {
	}
	public void test() {//实例化时，父类构造函数会调用这个方法。但是此时数据域name还没有被初始化，则会报错
		System.out.println(name.length());
	}
}
