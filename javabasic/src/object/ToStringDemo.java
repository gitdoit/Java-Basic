package object;
import employee.Employees;
/*����չʾ���û��Լ������toString����
 * �Զ���÷����ĺô���ʹ�û��ܹ�����Ļ�ö���ĸ���������Ϣ��
 * 
 * */
public class ToStringDemo {
	public static void main(String[] args){
		ToEmployee p = new ToEmployee("liu",100,2017,5,9);
		System.out.println(p.toString());
	}

}

class ToEmployee extends Employees{//��������������������toString ֱ��super.toString +[��������];
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
