package classdemo;
/*
 * ͨ�������ʼ���࣬���õ�һ�����ʵ����
 * ͨ������������һ����ķ�����
 * ͨ�������ȡ����ڲ���Ϣ��
 * ���ڲ��ĸ������ԡ����췽�������������͡�����ֵ�����������������ɵ���������
 */
import java.lang.reflect.Method;

public class ReflectDemo1 {

	public static void main(String[] args) throws ReflectiveOperationException {
		//forName�Ὣ����������ڴ沢ִ�г�ʼ�����õ�һ�������
		Class c = Class.forName("classdemo.ReflectTest");
		//ͨ��������ȡһ��ʵ��
		Object o = c.newInstance();
		//getMethods������ȡ�����ڲ������з���
		Method[] methods = c.getMethods();
		for(Method e : methods) {
			if(e.getName().equals("m")) {//�����������еķ�����Ϊm
				e.invoke(o);//��o�������m������
			}
			if(e.getName().equals("m1")) {
				for(Class m : e.getParameterTypes())//��ȡ�÷��������в������ͣ���Class������ʽ����
					System.out.println(m.getName());
			}
			
		}
	}

}

class ReflectTest{
	static {
		System.out.println("�ұ���ʼ���ˣ�");
	}
	int a;
	public ReflectTest() {
		System.out.println("�ұ�ʵ�����ˣ�");
	}
	
	public void m1(int i) {
		System.out.println(i);
	}
	public void m() {
		System.out.println("mִ��");
	}
}
