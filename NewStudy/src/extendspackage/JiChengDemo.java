package extendspackage;
import java.util.*;
/**
 * ��ʹ�ü̳�ʱ��������Ҳ����ָ������󡣵�����ʵ����ʱҲ��Ϊ�����洢�ռ�
 * ��������򲻾��ж�̬�ԡ�
 * ��̬ʱ�����ñ���ֻ�ܵ���������������ӵ�еķ����������ʵ������Ҳӵ�������������ô��ʱ����ֶ�̬�ԣ�������ʵ�������еķ�������ͬʱ
 * ��Ϊ������û�ж�̬�ԣ�����ʵ�ʵ��õ��Ǹ�������ʹ��ͬ���е�������
 * 
 * 
 * ����ѧϰ�̳�
 * ����������������һ��������shou����������һ���ַ�����һ��˽�е�show����������һ���ַ���
 * ���������ĸ�������������shou����������һ���ַ�����˽�е�show:����һ���ַ�����������print����ӡshow����
 * ������printDame:��ӡshou()
 * 
 * ����  ʵ�� = new ����();
 * ���Ҫʹ�ö�̬��ô�����ڸ����ж���һ�����������������и���/��д.������͸����ж��� ���������������
 * �����Ϳ����ø���������������еĸ��Ƿ��� ��ʵ��.���� �������������б���д�˲������õ������е����������   
 * ���������û������������������У���ô��Ҫ������ʾת������ʹ�������еķ��� ע��ת�����ᴴ��һ���µĶ���
 * (����)(ʵ��).����1
 * 
 * ���ʽ(ʵ��1 instanceof ʵ��2) �õ�����һ��booleanֵ��������ͬΪ��
 * ���ʽ(ʵ��1 == ʵ��2) ����˼���ж����������Ƿ�ָ��ͬһ��ʵ��������ַ�Ƿ���ͬ 
 * ���ʽ��ʵ��.equals(ʵ��1) ����˼���ж����������Ƿ�ָ��ͬһ��ʵ��������ַ�Ƿ���ͬ
 * ���ʽ���ַ���.equals(�ַ���1) �ж������ַ��������ĵ�ַ�Ƿ���ͬ
 * ���ʽ���ַ��� == �ַ���1 �ж������ַ����������Ƿ�һ���������ǵ�ַ
 * */
public class JiChengDemo extends B{
	public static void main(String[] args){
		B demo = new JiChengDemo();
		//��̬�������͵ı����������������͵Ķ���Ҳ���Խ������ͱ������������ͣ�ǰ���������ͱ���Ҫ��ָ��
		demo.shou();
		//��̬�󶨣���Ȼ�������Ǹ���B���ͣ�����ʵ������ΪJiChengDemo������ʹ�õ�shouΪ�����е�
		//�����������û��shou()���������ô��������Ǵ���ġ���Ҫǿת֮�����
		demo.printDemo();
		//demo��ʵ�������������ͣ���������û��printDemo����������ʹ�õ��Ǹ����е��������
		//��printDemo������ʹ����shou���������������������������shouʹ�õ��������е�
		demo.print();
		//printΪ�����еķ�����������û�С���print������ʹ����show���������������������
		//������Ϊ˽�еģ�ֻ���ڱ�����ʹ�á���print����ȴ�ڸ���֮�У�����ֻ��ʹ�ø����е�show����
		/*JiChengDemo a = new JiChengDemo();
		if(a instanceof JiChengDemo)
			System.out.println("�ǵ�");
		else
			System.out.println("���ǵ�");*/
		B element = new B();
		Object element1 = new B();
		System.out.println(element.equals(element1));
	}
	
	//�޲ι���
	JiChengDemo(){
		//super���ø����вι���
		//super(2);
	}
	//�вι���
	JiChengDemo(int a){
		System.out.println("����A��");
	}
	private String show(){
		return "����˽�з���";
	}
	@Override
	public String shou(){
		return  "JiCheng";
	}

}
class B{
	//ʵ����ʱ��������ִ�й��캯��ǰ�Ὣ�����е��޲ι��캯����ִ�С������������ȴ�ӡ��B���޲Ρ�
	B(){
		System.out.println("����B���޲�");
	}
	B(int a){
		System.out.println("����B���в�");
	}
	
	
	public String shou(){
		return  "B";
	}
	public void printDemo(){
		System.out.println(shou());
	}
	private String show(){
		return "B";
	}
	public void print(){
		System.out.println(show());
	}
	/*public boolean equals(Object obj){
		return false;
	}*/
}

/*class C{
	C(){
		this("����C����޲κ����ڵĵ���");
		System.out.println("����C��");
	}
	C(String s){
		System.out.println(s);
	}
	public double shou(){
		return 2.0;
	}
}*/