package arraypackage;
/* 
 * 
 * ������ʾ�˶��ڷ����ķ��Ͷ��壬�Լ��������ͱ���������
 * public static �����<T> returnType MethodName(T e)��������T������
 * public static <T extends Class> classname<T> methodName(T e)
 * 
 * �������Զ��巺���࣬������Ҫ������������
 * */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTest2 {
	public static void main(String[] args){
		GregorianCalendar[] birthdays = {new GregorianCalendar(1906,Calendar.DECEMBER,9),
				new GregorianCalendar(1906,Calendar.DECEMBER,8)
		};
		//����д��ArrayAlg.<GregorianCalendar>minmax(birthdays);����ʽ�ĸ����÷��������ͱ�����
		//���Ǳ��������Ը��ݷ����Ĳ��������Ƴ�T�����ͣ����Կ���ʡ�ԡ�
		Pair<GregorianCalendar> mm = ArrayAlg2.minmax(birthdays);
		System.out.println("min ="+mm.getFirst().getTime());
		System.out.println("max ="+mm.getSecond().getTime());
		
		
	}
	
}

class ArrayAlg2{
	public static <T extends Comparable> Pair<T> minmax(T[] a){//public static ��ļ����������ͱ��������˺������е�T
																	//��extends Comparable��˵�������ͱ���������Comparable�ӿ�
																	//Pair<T>�Ƿ������ͣ����Կ������Զ����ࣨ���ǣ�Employees�ࣩ
		if(a == null || a.length == 0 ) return null;
		T min = a[0];
		T max = a[0];
		for(int i = 0; i < a.length; i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair(min,max);
	}
	
	/*public static <T> T min(T[] a){//�÷���û���ڼ������ڶ����ͱ����������ƣ���û���������̳���Comparable�ӿڣ�����һ��if�ﲻ����compareTo����
		if(a == null || a.length == 0) return null;
		T min = a[0];
		for(int i = 0; i < a.length ; i++)
			if(min.compareTo(a[i]) > 0) min = a[i];
		return min;
	}*/
}
