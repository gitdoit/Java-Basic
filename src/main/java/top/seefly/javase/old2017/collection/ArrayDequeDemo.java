package collection;
import java.util.ArrayDeque;
/*
 * ArrayDeque<>ʵ����Deque<>(˫�˶���)�ӿڣ�������ӿڼ̳���Queue<>�ӿ�
 * 
 * ��Queue�ж��������¼�������
 * �����������ᱨ�쳣
 * add()���
 * remove()�Ƴ�
 * element() ���
 
 * offer() ��ӣ��������
 * poll()�Ƴ������ض����null
 * peek ��飬���ض����null
 * 
 * ��Ϊ����ʵ����˫�˶��нӿڣ����Ըö��п��������˲����ɾ��
 *  �׳��쳣				����ֵ 				�׳��쳣 			����ֵ 
���� addFirst(e) 		offerFirst(e) 		addLast(e) 		offerLast(e) 
�Ƴ� removeFirst() 	pollFirst() 		removeLast() 	pollLast() 
��� getFirst() 		peekFirst() 		getLast() 		peekLast() 

 * */
import java.util.Queue;

public class ArrayDequeDemo {
	public static void main(String[] args) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(3);//��Ч�� queue.add(3);
		queue.add(4);
		queue.addFirst(5);
		queue.addLast(6);
		queue.add(7);
		queue.removeLast();//��Ч��queue.remove();
		System.out.println(queue);
		
	}
}
