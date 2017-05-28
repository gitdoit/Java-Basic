package classdemo;
import java.util.Date;

import employee.Employees;
/* ��������ѧϰClass���ʹ��
 * 1,����.getClass() �õ�һ�� Classʵ�����������˶�����������
 * 2,Class.forName(����) Class�е�forName()��̬������ͨ�����������һ����Ӧ��Classʵ��.�������е���û���ҵ������׳��쳣
 * 3,Class��.newInstance()�ṹ��һ��c1������������޲�ʵ������c1��������û���޲ι��캯��������׳�IllegelAccessExcepiton
 * 
 * */
public class ClassDemo {
	public static void main(String[] args){
		Employees emp = new Employees("liu",100,2017,5,9);
		Class c = emp.getClass();//�õ�һ��classʵ������������emp��������
		System.out.println(c.getName());//��ӡc���������������
		
		String className = "java.util.Date";
		try{//forName()�������׳�һ���쳣
			Class c1 = Class.forName(className);//Class�е�forName()��̬������ͨ�����������һ����Ӧ��Classʵ��
			System.out.println(c1.getName());
			
			Object o = c1.newInstance();//newInstance�ṹ��һ��c1������������޲�ʵ������c1��������û���޲ι��캯��������׳�IllegelAccessExcepiton
			//Date d = (Date)Class.forName(className).newInstance();
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
			ex.printStackTrace();
		}
		
	}

}

