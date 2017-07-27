package arraypackage;
/* 
 * 
 * 该类演示了对于方法的泛型定义，以及对于类型变量的限制
 * public static 后面跟<T> returnType MethodName(T e)即方法的T的描述
 * public static <T extends Class> classname<T> methodName(T e)
 * 
 * 而对于自定义泛型类，尖括号要跟在类名后面
 * */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTest2 {
	public static void main(String[] args){
		GregorianCalendar[] birthdays = {new GregorianCalendar(1906,Calendar.DECEMBER,9),
				new GregorianCalendar(1906,Calendar.DECEMBER,8)
		};
		//可以写成ArrayAlg.<GregorianCalendar>minmax(birthdays);即显式的给出该方法的类型变量。
		//但是编译器可以根据方法的参数类型推出T的类型，所以可以省略。
		Pair<GregorianCalendar> mm = ArrayAlg2.minmax(birthdays);
		System.out.println("min ="+mm.getFirst().getTime());
		System.out.println("max ="+mm.getSecond().getTime());
		
		
	}
	
}

class ArrayAlg2{
	public static <T extends Comparable> Pair<T> minmax(T[] a){//public static 后的尖括号内类型变量描述了后面所有的T
																	//而extends Comparable则说明此类型变量必须有Comparable接口
																	//Pair<T>是返回类型，可以看成是自定义类（像是：Employees类）
		if(a == null || a.length == 0 ) return null;
		T min = a[0];
		T max = a[0];
		for(int i = 0; i < a.length; i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair(min,max);
	}
	
	/*public static <T> T min(T[] a){//该方法没有在尖括号内对类型变量进行限制，即没有描述他继承了Comparable接口，所以一在if里不能用compareTo方法
		if(a == null || a.length == 0) return null;
		T min = a[0];
		for(int i = 0; i < a.length ; i++)
			if(min.compareTo(a[i]) > 0) min = a[i];
		return min;
	}*/
}
