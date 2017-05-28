package classdemo;
import java.lang.reflect.*;
import java.util.*;
/*
 *该类中的方法用来得到一个类的全部信息。 
 *
 * */
public class ReflectDemo {
	public static void getClassInfo(String name){
		
		//Scanner in = new Scanner(System.in);
		//System.out.println("Enter class name (e.g. java.util.Date)");
		//name = in.next();
		try{
			Class c = Class.forName(name);
			Class superc = c.getSuperclass();
			String modifiers = Modifier.toString(superc.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class" + name);
			if(superc != null && superc != Object.class) System.out.print(" extends" + superc.getName());
			
			System.out.print("\n{\n");
			printConstructors(c);
			System.out.println();
			printMethods(c);
			System.out.println();
			printFields(c);
			System.out.println("}");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void printConstructors(Class c1){
		Constructor[] constructors = c1.getDeclaredConstructors();//返回一个 Constructor 对象，该对象反映此 Class 
		 //Constructor类描述类的构造方法	   							          对象所表示的类或接口的指定构造方法。
		for(Constructor c : constructors){
			String name = c.getName();//得到构造方法的名称
			System.out.print("   ");
			String modifiers = Modifier.toString(c.getModifiers());//返回此类或接口以整数编码的 Java 语言修饰符。
																   //然后toString再解码，然后得到修饰符是public 还是啥的
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name +  "(");
			
			//print parameter types
			Class[] parameTypes = c.getParameterTypes();//按照声明顺序返回一组 Class对象,这些对象表示此 Constructor对象所表示构造方法的形参类型。
			for(int j = 0 ;j < parameTypes.length; j++){
				if(j > 0) System.out.print(", ");
				System.out.print(parameTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class c1){
		Method[] methods = c1.getDeclaredMethods();//Method描述对象的方法
		for(Method m : methods){
			Class retType = m.getReturnType();//得到方法的返回值类型，返回值类型肯定是Class类啊
			String name = m.getName();
			
			System.out.print("   ");
			//print modifiers(修饰符),return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");//打印修饰符
			System.out.print(retType.getName() + " " + name + "(");//打印返回值类型
			
			//print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for(int j = 0; j < paramTypes.length; j++){
				if(j > 0) System.out.print(", "); 
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printFields(Class c1){
		Field[] fields = c1.getDeclaredFields();//返回一组数据域类
		for(Field f : fields){
			Class type = f.getType();//得到数据域类型，类型肯定是Class类
			String name = f.getName();//得到类名
			System.out.print("   ");
			String modifiers = Modifier.toString(f.getModifiers());//得到修饰符名
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
