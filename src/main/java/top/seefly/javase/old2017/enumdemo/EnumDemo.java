package enumdemo;
/* ö��������.values ��ö�ٶ�����ö���������ʽ����
 * 
 * ö�ٶ���.ordinal()�������ڸ����еı�ţ����㿪ʼ����ö�ٶ���.name()��������
 * 
 * ö�ٶ����������switch�� �����Ƚ�
 * */
public class EnumDemo {

	public static void main(String[] args){
		Color c1 = Color.BLUE;
		System.out.println("c1����ɫ��"+c1);//�����ڵ�c1 = c1.toString()
		for(Color c:Color.values())//ö�����еľ�̬values�����ǽ����е�ö��Ԫ����ö���������ʽ����
			System.out.println(c);
		//Enum<Color>[] cc = Color.values(); ����
		//Color[] bb = Color.values(); ö����������
		
		for(Color c : Color.values())//��֤ö������swithc�е�Ӧ��
			print(c);
		
		for(Color c : Color.values())//ordinal�������ڸ����еı�ţ����㿪ʼ����name��������
			System.out.println(c.ordinal()+ "--->"+ c.name());
		
		
	}
	

	
	public static void print(Color c){//ö��Ԫ����switch���ж�
		switch(c){//ע��Ҫ��break;
			case RED:{
				System.out.println(c);
				break;
			}
			case BLUE :{
				System.out.println(c);
				break;
			}
			case GREEN :{
				System.out.println(c);
				break;
			}
		}
	}
	
	public enum Color{//�Զ����ö������
		RED,
		BLUE,
		GREEN;
	}

}
