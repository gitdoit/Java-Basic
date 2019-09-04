package exception;
import java.util.*;
//��������2017��7��7�ո�ϰʱ��д��������ȫ
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
			System.out.println("finally��");
		}
	}
	public static boolean isNumber(int number)throws NumberException{
		if(number <= 0)
			new NumberException(number);
		return number%2==0?true:false;
	}

}

class NumberException extends Exception{//�Զ����쳣��Ҫ�̳и���
	private int number;
	public NumberException(){
		this(-1);
	}
	public NumberException(int number) {
		super("��ֵ�Ƿ���"+number);//�вι����е����˸����еĹ��췽����Ҫ�������ڵ�һ��λ�ã�
		this.number = number;
	}
	
}
