package wrapper_class;
/*
 * ���ֻ�������ÿһ�ֶ��ж�Ӧ�İ�װ���͡�������������ת���ɶ�����д���
 * byte		Byte
 * short    Short
 * int		Integer
 * long		Long
 * char		Character
 * float	Float
 * double	Double
 * boolean	Boolean
 * 
 * ÿ����װ���Ͷ����������췽��������ʹ���ַ������졣Ҳ����ʹ�û���������ֵ�����߻����������ñ�����
 * ���췽���еĲ�������Ϊ������ֵ���ͺͰ�װ�����ǿ���ʵ���Զ�װ�������ģ������ڲ�����ѡ���Ͽ����໥ʹ�á�
 * ֻҪ����ʧ���ȶ����ԡ�
 * 
 * XXX.parseXXX(String str)  ���ַ���������ת��Ϊ��Ӧ�İ�װ���͡�
 * XXX.toString(int i)		  ��intת��Ϊ�ַ���
 * XXX.valueOf(String\int)   ���ַ�����intֵת��ΪXXX����
 * */
public class Demo1 {
	public static void main(String[] args) {
		int num = 5;
		double num1 =5.0;
		Integer itg = new Integer(num);
		Integer itg1 = new Integer(5);
		Integer itg2 = new Integer("5");
		Integer itg3 = new Integer(itg);
		Integer itg4 = Integer.valueOf("5");
		String str = String.valueOf(5);//��������ֵ���ͣ�true��false�������߰�װ����ת�����ַ���
		
		
		//Integer itg3 = new Integer(num1);��ʧ���ȣ��޷�����
		//����ת�ͣ�����ͨ������
		Double doub = new Double(itg);
		//�õ��ö����double��ֵ
		itg.doubleValue();
		//Integer�ľ�̬���������ַ���ת����int��ֵ������String�е��ַ������ǿ�ת��
		int a = Integer.parseInt("5");
		//�����еĶ�����Ϊnull,�˽��Ϊfalse��
		System.out.println(itg.equals(doub));
		//��Щ��װ���Ͷ�ʵ����Comparable�ӿڣ��������Ƕ��ǿɱȵġ������ϴ��򷵻�-1�����Ϊ0����С����1
		System.out.println(itg.compareTo(itg1));
		//==�Ƚϵ����������ö���ĵ�ַ������������װ����ʵ����Ȼ��ֵ��ͬ��������������ͬ�Ķ��󡣷���false
		System.out.println(new Integer(5) == new Integer(5));
		//����֮��ͱ�ɻ�����ֵ���ͣ���ʱ���ٱȽϵ�ַ��������ֵ������true
		int b = itg;
		int c = itg;
		System.out.println(b == c);
		
	}

}
