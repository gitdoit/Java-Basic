package classload;

/*
 * 一个类一旦被加载入内存（不单单在磁盘内获取也可以从网络上），就不再加载了。
 * 如何判断一个类是否已经被加载了，这需要唯一的ID。这个ID就是加载器+包名+类名
 * 如果不同的加载器加载同一个类，那么这两个类是不同的
 * 
 * JVM启动时会形成由三个类加载器组成的初始类加载器。
 * 
 * 1.BootStarp ClassLoader:根类加载器
 * 	它负责加载java的jdk中的核心类（例如String）。除了此加载器其他所有加载器都是Java.lang.ClassLoader的子类
 * 	此加载器是由JVM自身实现的，使用平台相关的语言实现的。例如C语言或者汇编C++...
 * 
 * 2.Extension ClassLoader:扩展类加载器，负责加载扩展类，像是jre.lib.ext中的类
 * 
 * 3.System ClassLoader:系统类加载器
 * 
 * 4.Appliction CalssLoader 加载我们自己定义的类
 * 
 * 首先由BootstrapClassLoader把其他ClassLoader加载进来，再由这些ClassLoader再加载其他的类
 * 
 * 类加载器加载Class的步骤：
 * 	1.检测此类是否被加载过，加载过直接返回对应的java.lang.Class对象。没有则使用父类加载器加载
 *  2.若父类加载器没找到（再调它的父类..循环至根），就使用当前类加载器寻找Class文件，找到了载入，返回Class对象，没有则报异常
 *  3.若没有父类加载器，则使用跟类加载器，成功返回Class对象，不成功报异常
 *  
 */
public class ClassLoaderDemo {

	public static void main(String[] args) {
		//String是核心类它是由BootStarp ClassLoader加载的，此加载器没有名字，不是由java写的，无法获取实例
		System.out.println(String.class.getClassLoader());
		//调用jre中的类，是使用 ExtensionClassLoader加载器，加载器本身也是一个类，它是由上面的加载器加载的
		//System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader());
		//我们自己定义的类
		System.out.println(ClassLoaderDemo.class.getClassLoader().getClass().getName());
		//系统的classLoader
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
		
		ClassLoader c = ClassLoaderDemo.class.getClassLoader();
		while(c != null) {
			System.out.println("ClassLoader:"+c.getClass().getName());
			c = c.getParent();//注意，getParent不是得到父类。他们之间没有继承关系，是引用关系，A加载器中有个引用名字叫做parent指向B。
		}
	}

}
