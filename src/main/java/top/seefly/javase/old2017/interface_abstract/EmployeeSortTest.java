package top.seefly.javase.old2017.interface_abstract;
/*java.util.Arrays类中有一个方法Arrays.sort它可以对对象数组进行排序
 * 但是前提是需要排序的类的实例要实现接口java.lang.Comparable<T>
 * 我们对Employee类实现了该接口，并自己改写了其中的compareTo方法。
 * 此时可以使用Arrays.sort对该类型的对象数组进行排序（升序）
 * 
 * */
import java.util.*;

import top.seefly.javase.old2017.employee.Employees;

public class EmployeeSortTest {
	public static void main(String[] args){
		Employee[] staff = new Employee[3];//对象数组
		staff[0] = new Employee("liu",10000);
		staff[1] = new Employee("ma",11000);
		staff[2] = new Employee("yang",8000);
		System.out.println("排序之前");
		for(Employee e : staff)
			System.out.printf("name:%-10s   salary:%f\n",e.getName(),e.getSalary());
		Arrays.sort(staff);
		System.out.println("排序之后");
		for(Employee e : staff)
			System.out.printf("name:%-10s   salary:%f\n",e.getName(),e.getSalary());
	}
}

class Employee extends Employees implements Comparable<Employee>{//尖括号中的东西就像数据结构中自定义的EmleType

	public Employee(){
		super();
	}
	public Employee(String name,double salary){
		super(name,salary);
	}
	public Employee(String name,double salary,int year,int month,int day){
		super(name,salary,year,month,day);
	}
	
	@Override
	public int compareTo(Employee other){//覆写了compareTo参数类型必须和尖括号中的一致
		return Double.compare(salary, other.salary);
	}



}