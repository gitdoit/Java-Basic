package collection;
import java.util.GregorianCalendar;
/*
 * ����ʵ����Queue�ӿ�
 * �����ǰ���Ԫ�����ȼ�����
 * �ڲ��ǰ������ȼ����Ķ���
 * ÿ��ɾ��������ɾ����ͷԪ�أ�����ɾ�����ȼ���С��Ԫ�ء�
 * ���Ըö�������ִ�����ȼ����ȣ�����ִ�иö��������ȼ���������
 * �����ڵ�Ԫ�ض�Ҫ���пɱ��ԣ���ʵ����Comparable����
 * ����Ϊ��ָ���Ƚ���
 * */
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(4);
		queue.add(1);
		queue.add(6);
		queue.add(8);
		queue.add(4);
		//System.out.println(queue);��ӡ 1 4 6 8 4 �ɼ�����ֻ�ƶ���һ��Ԫ�ص�������������û������
		while(!queue.isEmpty()) {
			System.out.print(queue.poll());//��ӡ 14468
		}
	}
}
