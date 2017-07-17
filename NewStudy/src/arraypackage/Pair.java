package arraypackage;
/* ����Ϊ�Զ���ķ��ͻ�����
 * ������˽��������
 * �������췽��
 * ����������
 * �������ڵ�T Ϊ�����������
 * 
 * */          //Pair<T extends Comparable> \<T super String>
public class Pair<T> {/*Pair<T extends Comparable> ˵��Tֻ����Comparable�������ͣ�����������͡���Tֻ����Comparable
					�������Tֻ�ܽ����������͵Ļ�����Pair<T extends Number> ����Tֻ����Double Integer Short Long Float Byte
					���ַ��������������á���T�����޾���Number���������Ͳ����ٱ������߼���ֻ������������������
					Pair<T super String> ���ַ��������������ã���������Tֻ����String���������ĸ���
					*/
	
	private T first;
	private T second;

	public Pair() {
		first = null;
		second = null;
		}
	public Pair(T first,T second){
		this.first = first;
		this.second = second;
	}
	
	public T getFirst(){
		return first;
	}
	public T getSecond(){
		return second;
	}
	public void setFirst(T first){
		this.first = first;
	}

}
