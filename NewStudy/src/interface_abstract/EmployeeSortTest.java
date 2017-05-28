package interface_abstract;
/*java.util.Arrays������һ������Arrays.sort�����ԶԶ��������������
 * ����ǰ������Ҫ��������ʵ��Ҫʵ�ֽӿ�java.lang.Comparable<T>
 * ���Ƕ�Employee��ʵ���˸ýӿڣ����Լ���д�����е�compareTo������
 * ��ʱ����ʹ��Arrays.sort�Ը����͵Ķ������������������
 * 
 * */
import java.util.*;

import employee.Employees;

public class EmployeeSortTest {
	public static void main(String[] args){
		Employee[] staff = new Employee[3];//��������
		staff[0] = new Employee("liu",10000);
		staff[1] = new Employee("ma",11000);
		staff[2] = new Employee("yang",8000);
		System.out.println("����֮ǰ");
		for(Employee e : staff)
			System.out.printf("name:%-10s   salary:%f\n",e.getName(),e.getSalary());
		Arrays.sort(staff);
		System.out.println("����֮��");
		for(Employee e : staff)
			System.out.printf("name:%-10s   salary:%f\n",e.getName(),e.getSalary());
	}
}

class Employee extends Employees implements Comparable<Employee>{//�������еĶ����������ݽṹ���Զ����EmleType

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
	public int compareTo(Employee other){//��д��compareTo�������ͱ���ͼ������е�һ��
		return Double.compare(salary, other.salary);
	}



}