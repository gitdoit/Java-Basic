package exception;
/*
 * 异常是问题的描述，是将问题当做对象进行封装。
 * 体系：
 * 		Throwable
 * 			|--ERROR
 * 			|--Exception
 * 				|--RuntimeException
 * 异常的特点：异常体系中所有的类以及建立的对象都具有可抛性；
 * 			也就是说可以被throw和throws关键字所操作
 * 			只有异常体系具备这个特点
 * throw和throws的用法：
 * throw定义在函数内，用于抛出异常对象。
 * throws定义在函数上，用于抛出异常类，可以抛出多个用逗号隔开。
 * 
 * 当函数内容有throw抛出异常对象，并未进行try处理。必须要在函数上声明，否则编译失败
 * 注意，RuntimeException除外，他是免检异常
 * 如果函数声明了异常，调用者需要进行处理，处理方法可以用throws和try
 * 
 * 异常有两种，
 * 	编译时被检测异常
 * 		该异常在编译时，如果没有处理（没有抛，也没有try）那么编译失败
 * 		该异常被标识，代表着可以被处理
 * 	运行时异常
 * 		在编译时不需要处理，编译器不检查
 * 		该异常的发生建议不处理，让程序停止，需要对代码进行修正。
 * 
 * 异常处理的语句
 * try
 * {
 * 		需要别检测的代码
 * }
 * catch
 * {
 *		处理异常的代码 
 * }
 * finally
 * {
 * 		一定会执行的代码（System.exit(0)除外），一般用作关闭资源
 * }
 * 
 * 
 * 自定义异常：
 * 	定义类继承Exception或者RuntimeException
 * 	为了让该自定义类具备可抛性
 *  让该类具备操作异常的共性方法
 *  
 *  当定义自定义异常的信息时，可以使用父类已经定义好的功能
 *  异常信息传递给父类的构造函数
 * 
 * 异常的好处：
 * 		将问题进行封装
 * 		将正常流程代码和问题处理代码相分离，便于阅读
 * 
 * 异常的处理原则
 * 		处理方式有两种，try或者throws
 * 		调用到抛出异常的功能时，抛出几个就处理几个
 * 		父类的catch要放在下面，不然子类的异常catch块用不到
 * 		catch要定义针对性的处理语句，不要简单的定义打印语句
 * 		当捕获到的异常catch处理不了的时候那就抛出去
 * */
public class ExceptionTest {
	public static void main(String[] args){
			
		Sqare a = new Sqare(2,-3);
		a.getArea();
		
		
	}
}

interface Shape{
	public abstract void getArea();
}

class Sqare implements Shape{
	private double len,wid;
	public Sqare()throws IllegalValueException{//无参构造方法调用了有参，但是有参抛异常，无参不处理要抛出去
		this(0, 0);
	}
	public Sqare(double len,double wid) throws IllegalValueException{//这个异常造成的原因是用户输入不正确，所以不能在构造方法中解决
		if(len < 0 || wid < 0){
			throw new IllegalValueException(len,wid);//若参数不对则new一个异常抛出去
		}
		this.len = len;
		this.wid = wid;
	}
	
	public void getArea(){
		System.out.println(len * wid);
	}
}

class IllegalValueException extends RuntimeException{//由于用户输入的问题，在出问题之后程序无法通过自身解决，所以只能继承运行时异常。停止程序
	private double len,wid;
	IllegalValueException(double len,double wid){
		super(String.format("含有非法数值%f或%f", len,wid));//直接调用父类中的构造方法
	} 
}