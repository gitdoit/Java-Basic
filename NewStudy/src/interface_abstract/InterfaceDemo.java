package interface_abstract;
/*接口：可以理解为是一种标准，用它定义的类中所有方法全部是抽象的，且无法生成实例。需要子类对其中的方法全部实现之后才能用子类实例化。
 * 一个类可以实现多个接口
 * 一个接口可以继承另一个接口，甚至同时继承多个接口
 * 
 * 接口中常见的修饰符
 * 常亮：public static final
 * 方法：public abstract 
 * */
interface A{//接口A
	public abstract void method1();
}

interface B{//接口B
	public abstract void method2();
}


interface C extends A,B{//接口C可同时继承A.B
	
}


interface Interface {
	public static final int n = 3;
	public abstract void show();
}

class demo implements Interface{//类demo实例化接口
	public  void show(){
		System.out.print("实例化\n");
	}
}

class D extends demo implements C{//类D继承的同时可以实现接口
	public void method1(){//由于实现的接口中有两个方法需要实现
		
	}
	public void method2(){
		
	}
}
class InterfaceDemo{
	public static void main(String[] args){
		demo t = new demo();
		t.show();
		System.out.println(t.n);
		System.out.println(Interface.n);
		System.out.println(demo.n);//这三种调用都是可以的，因为数据域n是静态常量
	}
}