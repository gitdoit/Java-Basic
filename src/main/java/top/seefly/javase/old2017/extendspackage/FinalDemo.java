package extendspackage;
/*
 * ��final���εı�����ֻ��һ�θ�ֵ��������������ͬʱ��ֵ��Ҳ���ں�����и�ֵ������ʹ�á�ϵͳ�����������Ĭ�ϳ�ʼ����
 * */
public class FinalDemo {
	final int a = 6;
	final String str;
	final int c;
	//final char ch; chû�����κεط�������ĳ�ʼ�����ᱨ��
	final static double d;
	{
		//����ͨ��ʼ��������ɶ�final���ͱ����ĳ�ʼ��
		str = "hello";
		//�Ѿ���a��ֵ��ɡ��޷��ٶ����ٴθ�ֵ
		//a = 5;
	}
	static {
		//�����ھ�̬��ʼ�����жԾ�̬final�������е�һ�θ�ֵ
		d = 5;
		//ch = 'r';�Ǿ�̬�����޷��ھ�̬��ʼ�����ڸ�ֵ
	}
	public FinalDemo() {
		//�����ڹ��췽���ж�final���ͱ������г�ʼ����
		c =5;
	}
	public void test(final int a) {
		//a = 6; ���󣬲�������˷�����ʱ���Ѿ�����˳�ʼ�����޷��ٳ�ʼ��
	}
	public static void main(String[] args) {
		
		//final�������ñ���ʱ��ֻ�ܱ�֤�����ñ��������ö��󲻻ᷢ���ı䣬�����޷���֤�ö�������ݲ���ı䡣
		final int[] a = {1,3,5,2};
		a[2] = 8;
		
		final String str = "������" + 24;//�Ὣ"������" "24"�����ַ������У��´���ʹ�ô��ַ���ʱ��ֱ�Ӵӳ���ȡ
		final String str1 = "������" + String.valueOf(24);//��Ϊ���ʽ��ʹ����String���еľ�̬����
														//�ڱ���ʱ���Ὣstr1���������
		System.out.println(str == "������24");//Ϊ�棬��Ϊ==���"������24"������������ַ������ַ������е�ͬһ��
		System.out.println(str == str1);//Ϊ�٣�
		
		String str2 = "������24";
		System.out.println(str == str2);//Ϊ�棬�ڱ���׶ξͿ���ȷ��str2��ֵΪ�ַ������е�Ϊstr��������ַ���
		
		String str3 = "������";
		String str4 = "24";
		String str5 = str3 + str4;
		System.out.println(str == str5);//Ϊ�٣���Ϊstr5���������������Ӷ��ɵģ��޷��ڱ���׶�ȷ������ֵ
										//Ҳ����˵�޷���str5ָ�򻺳���е��ַ���

	}

}
