package wrapper_class;
/*
 * 八种基本类型每一种都有对应的包装类型。即将基本类型转换成对象进行处理！
 * byte		Byte
 * short    Short
 * int		Integer
 * long		Long
 * char		Character
 * float	Float
 * double	Double
 * boolean	Boolean
 * 
 * 每个包装类型都有两个构造方法，可以使用字符串构造。也可以使用基本类型数值，或者基本类型引用变量。
 * 构造方法中的参数，因为基本数值类型和包装类型是可以实现自动装箱与拆箱的，所以在参数的选择上可以相互使用。
 * 只要不丢失精度都可以。
 * 
 * XXX.parseXXX(String str)  将字符串中内容转换为对应的包装类型。
 * XXX.toString(int i)		  将int转换为字符串
 * XXX.valueOf(String\int)   将字符串或int值转换为XXX对象
 * */
public class Demo1 {
	public static void main(String[] args) {
		int num = 5;
		double num1 =5.0;
		Integer itg = new Integer(num);
		Integer itg1 = new Integer(5);
		Integer itg2 = new Integer("5");
		Integer itg3 = new Integer(itg);
		Integer itg4 = Integer.valueOf("5");
		String str = String.valueOf(5);//将基本数值类型（true，false），或者包装类型转换成字符串
		
		
		//Integer itg3 = new Integer(num1);丢失精度，无法编译
		//向上转型，可以通过编译
		Double doub = new Double(itg);
		//得到该对象的double数值
		itg.doubleValue();
		//Integer的静态方法，将字符串转换成int数值，但是String中的字符必须是可转的
		int a = Integer.parseInt("5");
		//参数中的对象不能为null,此结果为false。
		System.out.println(itg.equals(doub));
		//这些包装类型都实现了Comparable接口，所以他们都是可比的。参数较大则返回-1，相等为0，较小返回1
		System.out.println(itg.compareTo(itg1));
		//==比较的是两个引用对象的地址，这里两个包装类型实例虽然数值相同，但是是两个不同的对象。返回false
		System.out.println(new Integer(5) == new Integer(5));
		//拆箱之后就变成基本数值类型，此时不再比较地址，而是数值。返回true
		int b = itg;
		int c = itg;
		System.out.println(b == c);
		
	}

}
