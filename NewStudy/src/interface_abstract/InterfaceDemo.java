package interface_abstract;
/*�ӿڣ��������Ϊ��һ�ֱ�׼������������������з���ȫ���ǳ���ģ����޷�����ʵ������Ҫ��������еķ���ȫ��ʵ��֮�����������ʵ������
 * һ�������ʵ�ֶ���ӿ�
 * һ���ӿڿ��Լ̳���һ���ӿڣ�����ͬʱ�̳ж���ӿ�
 * 
 * �ӿ��г��������η�
 * ������public static final
 * ������public abstract 
 * */
interface A{//�ӿ�A
	public abstract void method1();
}

interface B{//�ӿ�B
	public abstract void method2();
}


interface C extends A,B{//�ӿ�C��ͬʱ�̳�A.B
	
}


interface Interface {
	public static final int n = 3;
	public abstract void show();
}

class demo implements Interface{//��demoʵ�����ӿ�
	public  void show(){
		System.out.print("ʵ����\n");
	}
}

class D extends demo implements C{//��D�̳е�ͬʱ����ʵ�ֽӿ�
	public void method1(){//����ʵ�ֵĽӿ���������������Ҫʵ��
		
	}
	public void method2(){
		
	}
}
class InterfaceDemo{
	public static void main(String[] args){
		demo t = new demo();
		t.show();
		System.out.println(t.n);
		System.out.println(Interface.n);
		System.out.println(demo.n);//�����ֵ��ö��ǿ��Եģ���Ϊ������n�Ǿ�̬����
	}
}