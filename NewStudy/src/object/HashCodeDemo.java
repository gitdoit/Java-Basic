package object;
import java.util.Objects;
import employee.Employees;
/*hash��ɢ����
 * ���ɶ��󵽴���һ������ֵ������û�й��ɵģ����ж����ԣ��������֤�ţ���
 * ��x,y��������ͬ�Ķ��������ǻ����ϲ�������ͬ��ɢ���롣
 * �Լ���дɢ����ʱһ�����ɶ������������ĳ���㷨�ó���
 * 
 * �����Լ�д��Equals�����ó�����������ȣ���ô������ɢ����ҲҪ��ȡ�
 * Equals��ʲô��ʽ�ó��Ľ��ۣ���ôɢ����ҲҪ���������ʽ��
 * ����
 * */

public class HashCodeDemo {
	public static void main(String[] args){
		HashEmployee p1 = new HashEmployee("liu",100,2017,5,9);
		HashEmployee p2 = new HashEmployee("liu",100,2017,5,9);//p1 p2��������ͬ���������Ϊ��ͬһ����Ա
		HashEmployee p3 = new HashEmployee("liu",55500,2017,5,9);
		System.out.println("��ʾɢ��������" + p1.toString());
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
	public int hashCode(){//��õķ�ʽ,��д��Object�еķ���
		return Objects.hash(name,salary,hireDay);
	}
	
	public int hashCode1(){//���ַ�������ȷ��������Ϊ���ǵ�׼ȷ��
		return 	  7 * name.hashCode()//String�����������ɢ�����㷨
				+ 11 * new Double(salary).hashCode()//doubleת��ΪDouble������ʹ��Double�е�ɢ�����㷨
				+ 13 * Objects.hashCode(hireDay);//Date����û��ɢ�����㷨��ʹ��Objects���еľ�̬ɢ�����㷨
	}
	
	public int hashCode2(){//���ַ����Ϻã���������Ϊnullʱ��hashCode����0������ʹ���䱾���ɢ�����㷨
		return 7 * Objects.hashCode(name)
				+ 11 * new Double(salary).hashCode()
				+ 13 * Objects.hashCode(hireDay);
	}
}