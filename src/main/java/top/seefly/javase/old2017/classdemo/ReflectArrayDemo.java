package classdemo;

import java.lang.reflect.Array;

/*
 * java.lang.reflect.Array
 * ����ͨ����̬�ķ�ʽ��������
 * 
 */
public class ReflectArrayDemo {

	public static void main(String[] args) {
		//����һ��String���͵ĳ���Ϊ10������
		Object arr = Array.newInstance(String.class, 10);
		Array.set(arr, 4, "������");
		Array.set(arr, 6, "liujianxin");
		Object str = Array.get(arr, 4);
		Object str1 = Array.get(arr, 6);
		System.out.println(str+""+str1);
	}

}
