package string;
/**
 * ����������ʾString��ĸ���ʹ�÷���*/
public class StringDemo {
	public static void main(String[] args){
		String arr = new String("java demo");
		String arr1 = "java demo";
		//arr1 ��arr��"java demo"�ĺ���������ͬ�ģ����Ƕ�������String���еķ�����
		//String arr2 = "java demo"; �����䲻�ᴴ���µĶ��󣬶���ָ��arr1�еĶ���
		arr1 = "java good";
		//�����䲢����ı�arr1����ָ�Ķ��󣬶������½�����һ������ָ��������ԭ�����ַ�����������
		arr.replace('j', 'J');
		//����һ���µ��ַ�������ԭ�����ַ��������е��ַ�j�����滻ΪJ֮�󸳸�����
		arr.replace("Ja", "ja");
		//����һ���µ��ַ�������ԭ�����ַ��������е��ַ���"JA"�����滻Ϊ"ja"֮�󸳸�����
		arr.replaceFirst("e", "AB");
		//����һ���µ��ַ�������ԭ�����ַ����е�һ���ַ���"e"�滻Ϊ"AB"֮�󸳸�����
		String[]  arr3 = "java#is#good".split("#");
		//���ַ�����ָ��������Ϊ�ָ�������ֳ��ַ�������洢��
		String[] arr4 = "java@is#very$good".split("[@#$]");
		//ֻҪ����������ʽ[@#$]������һ���ַ���������Ϊ�ָ���������ַ���
		
		char[] arr5 = arr1.toCharArray();
		//���ַ���ת��Ϊ����
		
		boolean a = false;
		String arr6 = String.valueOf(a);
		//��̬�����������ֻ������͵�����ת�����ַ�����
		char b = arr1.charAt(0);
		//��ȡ�ַ�����ָ���±���ַ�
		System.out.println(arr6);
		
	}

}
