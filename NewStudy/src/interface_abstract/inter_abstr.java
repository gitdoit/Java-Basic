package interface_abstract;
/*����չʾ��ʹ�ýӿڵ�����
 * �о������ǽ�һ������ϸ�ֳɸ������֣������������
 * ����һ������ѧ���࣬�е�ѧ�������̣���������������Ϊ���嵽���൱��
 * ��ô���е�ѧ������̳������Ϊ������Ȼ�ǲ������
 * ���Խ����������Ϊ��������������һ���ӿڣ��õ�ѧ������ʹ�øýӿڡ�
 * ��ѧ�����ʵ�ָýӿ��������Լ������ʵ���˹�����չ.
 * �̳У��������ǳ����е�һ��
 * �ӿڣ���ƽ�й�ϵ��ʵ�ֹ�����չ���ḻ��Ĺ���
 * 
 * �������ܶ��������У���չ���ܶ����ڽӿ���
 * */

abstract class Student{
	abstract void study();
	void sleep(){
		System.out.println("I AM SLEEP\n");
	}
}

interface Smoke{
	public abstract void smoke();
}

class GoodStudent extends Student{
	void study(){
		System.out.println("i am good student\n");
	}
}

class BadStudent extends Student implements Smoke{
	void study(){
		System.out.println("i am bad student\n");
	}
	public void smoke(){
		System.out.println("I am smoking,fuck off\n");
	}
}
public class inter_abstr {
	public static void main(String[] args){
		GoodStudent liujianxin = new GoodStudent();
		BadStudent yuxiangma = new BadStudent();
		liujianxin.sleep();
	}

}
