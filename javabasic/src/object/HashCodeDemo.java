package object;
import java.util.Objects;
import employee.Employees;
/*hash是散列码
 * 是由对象到处的一个整型值，他是没有规律的，具有独特性（像是身份证号）。
 * 若x,y是两个不同的对象，则他们基本上不会有相同的散列码。
 * 自己重写散列码时一般是由对象的数据域由某种算法得出。
 * 
 * 若由自己写的Equals方法得出两个对象相等，那么他俩的散列码也要相等。
 * Equals由什么方式得出的结论，那么散列码也要根据这个方式来
 * 就像
 * */

public class HashCodeDemo {
	public static void main(String[] args){
		HashEmployee p1 = new HashEmployee("liu",100,2017,5,9);
		HashEmployee p2 = new HashEmployee("liu",100,2017,5,9);//p1 p2数据域相同，可以理解为是同一个雇员
		HashEmployee p3 = new HashEmployee("liu",55500,2017,5,9);
		System.out.println("演示散列码如下" + p1.toString());
		System.out.println(p1.hashCode()+"\n" + p2.hashCode() + "\n" + p3.hashCode());
	}
	
}

class HashEmployee extends Employees{
	public HashEmployee(){
		super();
	}
	public HashEmployee(String name,double salary,int year,int month,int day){
		super(name,salary,year,month,day);
	}
	
	@Override
	public int hashCode(){//最好的方式,重写了Object中的方法
		return Objects.hash(name,salary,hireDay);
	}
	
	public int hashCode1(){//这种方法不能确保数据域为空是的准确性
		return 	  7 * name.hashCode()//String对象由自身的散列码算法
				+ 11 * new Double(salary).hashCode()//double转换为Double对象，再使用Double中的散列码算法
				+ 13 * Objects.hashCode(hireDay);//Date类中没有散列码算法，使用Objects类中的静态散列码算法
	}
	
	public int hashCode2(){//这种方法较好，当数据域为null时候hashCode返回0，否则使用其本身的散列码算法
		return 7 * Objects.hashCode(name)
				+ 11 * new Double(salary).hashCode()
				+ 13 * Objects.hashCode(hireDay);
	}
}