package top.seefly.javase.old2017.classdemo;

import top.seefly.javase.old2017.employee.Employees;

/* 本类用来学习Class类的使用
 * 1,对象.getClass() 得到一个 Class实例，它描述了对象所属的类
 * 2,Class.forName(类名) Class中的forName()静态方法会通过其参数构建一个对应的Class实例.若参数中的类没有找到，会抛出异常
 * 3,Class类.newInstance()会构建一个c1所描述的类的无参实例，若c1描述的类没有无参构造函数，则会抛出IllegelAccessExcepiton
 * 
 * */
public class ClassDemo {
	public static void main(String[] args){
		Employees emp = new Employees("liu",100,2017,5,9);
		Class c = emp.getClass();//得到一个class实例，它描述了emp所属的类
		System.out.println(c.getName());//打印c所描述的类的名字
		
		String className = "java.util.Date";
		try{//forName()方法会抛出一个异常
			Class c1 = Class.forName(className);//Class中的forName()静态方法会通过其参数构建一个对应的Class实例
			System.out.println(c1.getName());
			
			Object o = c1.newInstance();//newInstance会构建一个c1所描述的类的无参实例，若c1描述的类没有无参构造函数，则会抛出IllegelAccessExcepiton
			//Date d = (Date)Class.forName(className).newInstance();
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
			ex.printStackTrace();
		}
		
	}

}

