package extendspackage;
/*
 * ��ʵ��������ʱ����ݹ�����ȥ�ȹ��츸��
 * �������еķ��������า�ǣ����ڸ��๹�캯����ʹ���������������ʱ�п��ܳ���
 * 
 * ��ֹ���౻�̳еķ�ʽ�����֡�
 * 1�����౻����Ϊfinal�������յġ����޷����޸���̳�
 * 2�������еĹ��췽����������Ϊprivate
 * */
public class Demo1 {

	public static void main(String[] args) {
		Sub a = new Sub();
		
	}

}

class Base{
	public Base() {//������ʵ����ʱ�ȹ��츸��
		test();
	}
	public void test() {//���า����������������Ը����еĹ��췽�����õĲ������������
		System.out.println("����test����");
	}
}

class Sub extends Base{
	private String name;
	public Sub() {
	}
	public void test() {//ʵ����ʱ�����๹�캯�������������������Ǵ�ʱ������name��û�б���ʼ������ᱨ��
		System.out.println(name.length());
	}
}
