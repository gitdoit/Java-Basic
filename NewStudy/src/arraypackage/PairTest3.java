package arraypackage;

public class PairTest3 {
	public static void main(String[] args){
		Pair<String> i = new Pair<>();
		Pair<?> b = new Pair<String>();
		System.out.println(b.getClass().getName());
		//b.setFirst("first") ERROR ��?���ܷ��Ͷ���ʱ���������ø÷��Ͷ�����Ϊ��֪������ʲô���������������޷�ȷ���ܷ���������
		b.setFirst(null);//���ǿ�������null
		i.setFirst("first");
		fun(i);
		fun1(i);
		fun2(i);
		
		
		/************************����������ֵ������������������Ƚ�****************************/
		//Pair<Object> c = null;
		//c = i; �����޷�ͨ������
		
		Pair c = null;
		c = i;
		
		Pair<?> d = null;
		d = i;
	}
	
	/*public static void fun(Pair<Object> temp){ �βεķ��ͱ�����ʵ�εĸ������ͬ�࣬�����޷�ͨ�����롣
		System.out.println(temp.getFirst());
	}*/
	
	public static  void fun(Pair<String> temp){//ͬ����Ա���ͨ��
		System.out.println(temp.getFirst());
	}
	
	public static void fun1(Pair<?> temp){//����ʹ��? �������Խ����������͵ķ���
		System.out.println(temp.getFirst());//���Է��ʣ������޷��޸�
		//temp.setFirst("dd");δȷ���ķ��ͣ��޷�ȷ��T�Ǹ�ʲô������������������T����ģ����Բ��ܸ���
	}
	
	public static void fun2(Pair temp){//���Բ������͡�����Ҳ����
		System.out.println(temp.getFirst());
	}
	
}

