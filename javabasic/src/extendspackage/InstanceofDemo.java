package extendspackage;
/*
 * ����������ʾinstanceof���÷�
 * 
 * 1.ʵ�� instanceof ��/�ӿ�
 * �����ж�ǰ���ʵ���Ƿ��������������Լ̳й�ϵ�����ǽӿ�ʵ�֡�
 * ��ʵ������������򷵻�false�����򷵻�true
 * ��ʵ������û�����Լ̳й�ϵʱ������String���ʵ����Math���Ƚϣ���ô�������ʧ��
 * */
public class InstanceofDemo {

	public static void main(String[] args) {
		//��Ȼ��������ΪObject������instanceof�Ƚϵ���ʵ�����͡��򷵻ص���ture
		Object str = new String();
		System.out.println(str instanceof String);
		
		//true
		System.out.println(str instanceof Object);
		//str��ʵ��������String������ʵ����Comparable�ӿڣ����Է��ص���ture
		System.out.println(str instanceof Comparable);
		
		//��Ȼ��ʵ������û�м̳л���ʵ�ֹ�ϵʱ�������󣬵����������������ΪObject�ڱ���ʱ��ƭ�����������������false
		System.out.println(str instanceof Math);
		
		String s = "Hello";
		//System.out.println(s instanceof Math);����ʧ��

	}

}
