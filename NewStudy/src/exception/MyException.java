package exception;
import java.util.*;
//该类是在2017年7月7日复习时所写，并不完全
public class MyException {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a;
		a = in.nextInt();
		try {
			System.out.print(isNumber(a));
		}
		catch(NumberException ex) {
			ex.printStackTrace();
		}
		finally {
			System.out.println("finally块");
		}
	}
	public static boolean isNumber(int number)throws NumberException{
		if(number <= 0)
			new NumberException(number);
		return number%2==0?true:false;
	}

}

class NumberException extends Exception{//自定义异常需要继承父类
	private int number;
	public NumberException(){
		this(-1);
	}
	public NumberException(int number) {
		super("数值非法："+number);//有参构造中调用了父类中的构造方法需要将他放在第一个位置；
		this.number = number;
	}
	
}
