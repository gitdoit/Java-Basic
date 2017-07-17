package object;

import java.util.*;

import employee.Employees;


/*�����Ǹ��ݺ����Ĳ�ͬ�Ĳ���������ʹ�ò�ͬ�ķ���
 * ����������͵��ж����� ����ʵ�����ͣ�������������
 *Object�е�equals�����Ƚϵ�������ʵ���ĵ�ַ�Ƿ���ͬ(��==һ��)
 *��������������д�������(String������д�����������ֻҪ�ַ������ַ�������ͬ�ͷ�����)ʹ�����ٱȽ�������ַ����������������
 *
 *����equals�����Ķ���׼��
 *�Է��ԣ�x.equals(x) �ض�����true
 *�Գ��ԣ�x.equals(y) ��y.equals(x)���Ҫһ��
 *�����ԣ���x.equals(y)��y.equals(z) ����true   ��x.equals(z)����true
 *һ���ԣ���x,��yû�з����仯�����ҽ���x.equals(y)����ֵҪ��y.equals(x)���һ��
 * */
class Employee extends Employees{
	public Employee(){
		
	}
	public Employee(String name,double salary,int year,int month,int day){
		super(name,salary,year,month,day);
	}
	
	@Override
	public boolean equals(Object otherObject){//��׼���巽ʽ
		if(this == otherObject) return true;//�����õ���ͬһ�����󣬷�����
		if(otherObject == null) return false;//������Ϊ�շ��ؼ�
		if(getClass() != otherObject.getClass())return false;//���������Ͳ�һ�£��򷵻ؼ١���getClass�õ�����ʵ����������
		
		Employee other = (Employee)otherObject;//���϶�ͨ������˵��������һ����this��ͬ���ͷǿղ���ͬһ������Ķ������ǿת
		return Objects.equals(name, other.name)//�÷����Ƚ϶���������
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
