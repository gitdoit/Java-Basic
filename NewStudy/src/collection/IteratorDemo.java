package collection;
/*
 * �����ĸ�����������Collection��Map�����������û�е����������,��������������������
 * ���Ե�������ʵ��ֻ�ܴӼ��϶�����ȡ������Collectionʵ���ж����е�������Iterator����Ϊ�˷���������Collection�У����ຬ�д˷�������԰�
 * �ڵ��������м��ϲ��ܷ����ı䣬����ʹ�õ�������remove������ʹ�ü��ϵ�remove�������׳��쳣
 * hasNext����ֻ���������¸�Ԫ�أ�����ı��������ָ�롣��ָ�벻�����
 * ֻ�е���next�����Ż���ָ����ƣ��һ᷵��ָ�������ĸ�Ԫ��
 * 
 * ���򼯺�HashSet�еĵ�����ֻ�ܴ���remove �������
 * ������LinkedList�е�ListIterator�������������ڵ������������������Ԫ��,����ָ��ǰ��
 * ע�⣺�κε������������������ε���remove��remove�ĳ��ֶ�Ҫ�ж�Ӧ��next�����������������м䲻�ܶ�
 * 
 * 
 * Iterator�ӿ��ж������������󷽷�,��һ�����췽��
 * Collection�ӿڼ̳���Iterator�ӿ�
 * List�ӿڼ̳���Collection�ӿ�
 * ArrayList ʵ���� List �ӿ�
 * ����ArrayList��ʵ����Iterator�ӿ��е�������������һ�����췽��
 * ������������ʵ���������ڲ���Itr�С�
 * ArrayList.Iterator����Itr��ʵ��
 * */
import java.util.*;

public class IteratorDemo {

	public static void main(String[] args) {
		Collection<String> book = new HashSet<String>();
		book.add("������");
		book.add("��˧");
		book.add("�������");
		book.add("��û��˵");
		book.add("dd");
		Iterator itr = book.iterator();
		while(itr.hasNext()) {							//hasNext����ֻ������û����һ��Ԫ�أ�����ʹ����ָ�����
			//System.out.println(itr.next());			ֻ��next�����Ż�ʹ����ָ����ƣ����Բ�Ҫ��һ��ѭ���е�������next������
			if(itr.next().equals("dd"))					//���������������������ж����ʹ��������next����whileѭ���л����NoSuchElementException
				itr.remove();							//��Ϊ������������һ������ָ��ָ��ԭ���ϣ���Ԫ���Ϸ����˸ı�ʱ�������ɲ���ı�ָ��������ʹ�ô˷���ʹ��Ԫ���ϲ��ܷ����ı䣬�����쳣
														//book.remove("������");����ʱ�����ϲ��ܷ����ı䡣��Ҫ�ı䣬ֻ��ʹ�õ�������remove����
		}
		System.out.println(book);
		
		List<String> list = new LinkedList<>();			//�˼���������ģ��ʺ�����λ���ϵĲ�����ɾ��
		list.addAll(book);								//��ʼ������
		
		ListIterator<String> lit = list.listIterator();//�½�������������˵�����������������е�����������add/previous���ܡ�һ���������˵��������˼��ϲ��������иı�
		System.out.println("next:"+lit.next());
		//list.add(0,"see");							�ڵ��������в���ͨ��������ķ����ı�����ṹ
		System.out.println("next:"+lit.next());
		list.set(0, "best");							//�ڵ�������Ȼ���ܸ��ļ��Ͻṹ����ȴ���Ըı伯��ָ��λ���ϵ����ݡ�
		lit.add("see");									//��ʱ��������next����������see�����������ĵڶ���λ��֮��
		System.out.println("previous:"+lit.previous());;//�˷�����next���������෴������ʹָ��ǰ�ƣ�������ָ����Ԫ��
		lit.add("fly");
		
		
		
		
		//System.out.println(list);
		for(String e:list) {							//�κ�ʵ����Iterator�ӿڵ��඼��ʹ��for eachѭ������
			System.out.print(e);
		}
	}

}
