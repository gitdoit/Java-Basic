package top.seefly.javase.old2017.innerclass;
/*内部类可以直接访问外部类的成员，包括私有
 * 外部类要访问内部类必须先实例化
 * 内部类可以被private static 修饰
 * 当内部类用static修饰时，它不可以访问外部非静态成员
 * 且当内部类中有静态成员时，该内部类必须定义为静态内部类
 * 
 * 当外部类中的静态成员访问内部类时，内部类必须也要是静态的
 * */
public class InnerClass{
	public static void main(String[] args){
		//Outer.Inner demo = new Outer().new Inner();//直接构建内部类的格式，前提是内部类没有被private、static修饰
		//demo.method();
		
		Outer.Inner d = new Outer.Inner();//当内部类为静态内部类可以这样调用，因为Inner是静态的，当Outer加载时Inner就存在了
		d.method();//这两行可：new Outer.Inner().method();
		
		Outer.Inner.ptr();//可直接访问类中的静态成员
		Outer.method();
	}
	
}

class Outer{
	private int i = 3;
	
	/**************************内部类1*********************************/
	static class Inner{//内部类
		int i = 4;
		void method(){
			System.out.println("这是内部" + this.i/*Outer.this.i这个是外部类的i*/ );
			//demo();内部类访问外部类不需要实例化，可直接引用
		}
		static void ptr(){//静态方法
			System.out.println("静态内部类中的静态方法");
		}
		
	}
	/*************************内部类2*********************************/
	
	static class Inner2{
		void show(){
			System.out.println("静态内部类的show方法");
		}
	}
	/**************************外部类成员*************************************/
	void demo(){
		System.out.println("demo");
	}
	void funcation(){
		//System.out.println("这是外部");
		Inner in = new Inner();//外部类要访问内部类要先构造实例
		in.method();
	}
	public static void method(){//外部类的静态成员
		new Inner2().show();//当Inner2为非静态的时候不能这样，因为method为静态方法，在最开始就加载了
	}
}





