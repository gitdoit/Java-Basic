package classload;
/*
 * 
 * ��ļ�����ָ���������class�ļ������ڴ棬��Ϊ֮����һ��class����
 * ������ʹ���κ���ʱ������Ϊ֮����java.lang.class����
 * ���ط�Ϊ�����裺���ء����ӡ���ʼ��
 * 
 * 1.���أ���������ļ�������ɣ���������JVM�ṩ�����ǻ�����ͨ���̳�ClassLoader����ʵ���Լ��ļ�����
 * 2.���ӣ���֤����ڲ��ṹ��Ϊ��̬���Է����ڴ棬����Ĭ�ϳ�ʼֵ(���ǳ�ʼ��)
 * 3.��ʼ������Ҫ���ǶԾ�̬���Գ�ʼ������̬��ʼ��(������̬��ʼ����)��˳��ִ�С�
 * 
 * ʲôʱ�������ࣿ
 * 1.�κη�ʽ����ʵ����ʱ��
 * 2.������ľ�̬������ʱ��
 * 3.�������ӿڵľ�̬���ԣ���Ϊ��ľ�̬���Ը�ֵ��ʱ��
 * 3.ʹ�÷��䴴�����class�����ʱ��
 * 4.��ʼ��ĳ�������ʱ�򣬸���������е����ᱻ��ʼ��������Խ��Խ�ȳ�ʼ��
 * ע�⣺����final static���ԣ��������ֵ�ܹ��ڱ���ʱ�ھ���ȷ������
 * ��ô������һ������������������������ĳ�ʼ����
 */


class Tester
{
	static {
		System.out.println("Tester ��ľ�̬��ʼ����");
	}
	
}

public class ClassLoadDemo {
	//�κεط�����AA��������ɸ��� �ĳ�ʼ���������ڱ���ʱ��ȷ��������Ϊ�����
	public static final int AA = 5;
	//TIME�����ڱ���ʱ��ȷ�����������Ե�������ʱ��������ĳ�ʼ��
	public static final String Time = System.currentTimeMillis() + "";
	public static int a = 5;
	static {
		a = 4;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader c1 = ClassLoader.getSystemClassLoader();
		//���������Ǽ����࣬������ִ�г�ʼ�����򲻻�ִ�г�ʼ����
		c1.loadClass("loadclass.Tester");
		System.out.println("ϵͳ����Tester�࣡step 1");
		//�����ִ����ĳ�ʼ������ִ�е���ľ�̬��ʼ����
		Class.forName("loadclass.Tester");
		
	}

}
