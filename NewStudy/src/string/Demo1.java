package string;
/*
 * ������ʾ���ַ����Ľ�ȡ��ƴ��
 * substring(begaindex,enddex);
 * substring(begaindex);
 * 
 * �ַ��������Ƿ��ڴ洢���й����
 * */
public class Demo1 {
	public static void main(String[] args) {
		String str = "Hello";//Hello�ǲ��ɱ�ģ�����str�ǿɱ�����
							//������һ������Ҳָ��Hello��ô�����Ὺ���¿ռ�
		String s = str.substring(0,3);//��ȡ0��1��2
		String s1 = str.substring(2);//��ȡ��2��ʼ,����2
		
		
		String demo = s + s1;//�ַ�������ʹ��+ƴ��
		demo = str + " world";
		
		boolean flag = demo.equals(str);//�Ƚ������ַ����е�������ȷ�
										//����ʹ��==����Ϊ���Ƚϵ��ǵ�ַ
		
	}
}
