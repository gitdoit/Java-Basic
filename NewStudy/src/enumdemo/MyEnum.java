package enumdemo;
/*�Զ����ö�����ͣ����а������������з�����
 * ����ʾ��Enum.valueOf()������ʹ��
 * �Լ�ö�ٶ��������==�Ƚ�
 * 
 * */
import java.util.*;

public class MyEnum {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size(SAMLL,MEDIUM,LARGE,EXTRA_LARGE)");
		String input = in .next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);//Enum.valuesof(ö�����ͣ�ö��Ԫ����)���õ���ö�����͵�����Ϊ��ö��Ԫ��������ö�ٶ���
													//�þ�̬�������׳�һ������ʱ�쳣��û�ж�Ӧ��Ԫ����ʱ
		System.out.println("size:"+size);
		System.out.println("size="+size.getSize());//����������ö�ٶ����������
		if(size == Size.SMALL)
			System.out.println("�㴩����S��");
		
	}
	

}

enum Size{//�Զ���ö�����Ͱ���������
	//����������൱��new һ��ö�ٶ�����
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("LX");
	private Size(String size){
		this.size = size;
	}
	public String getSize(){
		return size;
	}
	private String size;
}