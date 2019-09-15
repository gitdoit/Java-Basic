package top.seefly.javase.old2017.object;

import top.seefly.javase.old2017.employee.Employees;

import java.util.*;



/*重载是根据函数的不同的参数类型来使用不同的方法
 * 但是这个类型的判断依据 不是实际类型，而是声明类型
 *Object中的equals方法比较的是两个实例的地址是否相同(与==一样)
 *可以在子类中重写这个方法(String类中重写了这个方法，只要字符串内字符序列相同就返回真)使他不再比较两个地址，而是其他东西。
 *
 *关于equals方法的定义准则：
 *自反性：x.equals(x) 必定返回true
 *对称性：x.equals(y) 与y.equals(x)结果要一致
 *传递性：若x.equals(y)和y.equals(z) 返回true   则x.equals(z)返回true
 *一致性：若x,和y没有发生变化，当且仅当x.equals(y)返回值要和y.equals(x)结果一致
 * */
class Employee extends Employees {
	public Employee(){
		
	}
	public Employee(String name,double salary,int year,int month,int day){
		super(name,salary,year,month,day);
	}
	
	@Override
	public boolean equals(Object otherObject){//标准定义方式
		if(this == otherObject) return true;//若引用的是同一个对象，返回真
		if(otherObject == null) return false;//若参数为空返回假
		if(getClass() != otherObject.getClass())return false;//若参数类型不一致，则返回假。（getClass得到的是实际类型名）
		
		Employee other = (Employee)otherObject;//以上都通过了则说明参数是一个和this相同类型非空不是同一个对象的对象。则可强转
		return Objects.equals(name, other.name)//该方法比较对象数据域
				&&salary == other.salary
				&&Objects.equals(hireDay, other.hireDay);
	}
}
public class EqualsDemo {
	public static void main(String[] args){
		Employee p1 = new Employee("liu",100,2017,5,9);
		Employee p2 = new Employee("liu",100,2017,5,9);
		System.out.println(p1.equals(p2));
	}
}
