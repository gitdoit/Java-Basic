package extendspackage;
/*
 * ��ʼ����
 * �빹�췽�����ƣ��������빹�췽��ǰִ�У��һ����ż̳������췽��һ��ȥִ�С�
 * �����ܽ����κβ�������������ʽִ�еġ�
 * ÿһ�ε��ù��췽��(�в��޲�)֮ǰ����ִ����ͨ��ʼ���飬����̬��ʼ����ֻ�ڸ�����ص�ʱ��ִ��һ�Σ��ҽ�һ�Ρ����������
 * 
 * ��̬��ʼ���飬����������ظ���ʱ��ִ�иÿ飬��ִֻ��һ�Ρ�
 * */
public class Demo2 {

	public static void main(String[] args) {
		new Leaf();
		new Leaf();//ʵ�����������󣬵������о�̬��ֻ����ִ��һ��

	}

}

class Root{
	static {
		System.out.println("Root�ľ�̬��ʼ����");
	}
	{
		System.out.println("Root����ͨ��ʼ����");
	}
	public Root() {
		System.out.println("Root���޲ι��췽��");
	}
}
class Mid extends Root{
	static {
		System.out.println("Mid�ľ�̬��ʼ����");
	}
	{
		System.out.println("Mid����ͨ��ʼ����");
	}
	public Mid() {
		System.out.println("Mid���޲ι��췽��");
	}
	public Mid(String msg) {
		this();
		System.out.println("Mid���вι��췽���������ֵΪ:"+msg);
	}	
}

class Leaf extends Mid{
	static {
		System.out.println("Leaf�ľ�̬��ʼ����");
	}
	{
		System.out.println("Leaf����ͨ��ʼ����");
	}
	public Leaf() {
		super("���Բ���");
		System.out.println("Leaf���޲ι��췽��");
	}
}