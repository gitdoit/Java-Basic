package object;
import employee.Employees;
/*该类展示了用户自己定义的toString方法
 * 自定义该方法的好处是使用户能够方便的获得对象的各种有用信息。
 * 
 * */
public class ToStringDemo {
	public static void main(String[] args){
		ToEmployee p = new ToEmployee("liu",100,2017,5,9);
		System.out.println(p.toString());
	}

}

class ToEmployee extends Employees{//若此类有子类则子类中toString 直接super.toString +[新数据域];
	public ToEmployee(){
		super();
	}
	public ToEmployee(String name,double salary,int year,int month,int day){
		super(name,salary,year,month,day);
	}
	
	@Override
	public String toString(){
		return String.format("%s[name=%s,salary=%f,hireDay:", getClass().getName(),name,salary)
				+ hireDay + "]";
	}
}
