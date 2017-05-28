package innerclass;
/*�ڲ������ֱ�ӷ����ⲿ��ĳ�Ա������˽��
 * �ⲿ��Ҫ�����ڲ��������ʵ����
 * �ڲ�����Ա�private static ����
 * ���ڲ�����static����ʱ���������Է����ⲿ�Ǿ�̬��Ա
 * �ҵ��ڲ������о�̬��Աʱ�����ڲ�����붨��Ϊ��̬�ڲ���
 * 
 * ���ⲿ���еľ�̬��Ա�����ڲ���ʱ���ڲ������ҲҪ�Ǿ�̬��
 * */
public class InnerClass{
	public static void main(String[] args){
		//Outer.Inner demo = new Outer().new Inner();//ֱ�ӹ����ڲ���ĸ�ʽ��ǰ�����ڲ���û�б�private��static����
		//demo.method();
		
		Outer.Inner d = new Outer.Inner();//���ڲ���Ϊ��̬�ڲ�������������ã���ΪInner�Ǿ�̬�ģ���Outer����ʱInner�ʹ�����
		d.method();//�����пɣ�new Outer.Inner().method();
		
		Outer.Inner.ptr();//��ֱ�ӷ������еľ�̬��Ա
		Outer.method();
	}
	
}

class Outer{
	private int i = 3;
	
	/**************************�ڲ���1*********************************/
	static class Inner{//�ڲ���
		int i = 4;
		void method(){
			System.out.println("�����ڲ�" + this.i/*Outer.this.i������ⲿ���i*/ );
			//demo();�ڲ�������ⲿ�಻��Ҫʵ��������ֱ������
		}
		static void ptr(){//��̬����
			System.out.println("��̬�ڲ����еľ�̬����");
		}
		
	}
	/*************************�ڲ���2*********************************/
	
	static class Inner2{
		void show(){
			System.out.println("��̬�ڲ����show����");
		}
	}
	/**************************�ⲿ���Ա*************************************/
	void demo(){
		System.out.println("demo");
	}
	void funcation(){
		//System.out.println("�����ⲿ");
		Inner in = new Inner();//�ⲿ��Ҫ�����ڲ���Ҫ�ȹ���ʵ��
		in.method();
	}
	public static void method(){//�ⲿ��ľ�̬��Ա
		new Inner2().show();//��Inner2Ϊ�Ǿ�̬��ʱ������������ΪmethodΪ��̬���������ʼ�ͼ�����
	}
}





