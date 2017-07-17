package collection;

import java.util.HashSet;

/*
 * set��ָ�������˼������һ�����ӣ������ڵ�Ԫ�ر��������ͬ(equals,hashCode)������֮��û��˳��
 * ����ж�����Ԫ���Ƿ���ͬ��
 * 	���ݸ�Ԫ�ص�equals��hashCode����
 * 	�������Ԫ��ͨ��equals�����Ƚ���ͬ����hashCode��������ֵ��ͬ����ô���ǻὫ��Ԫ�ط�������ڣ�����hashCode����ֵ����λ��
 * 	�����������Ԫ��equals�Ƚϲ�ͬ������hashCode��������ֵ��ͬ����ô�Ὣ��Ԫ��ͬ��������ʽ���ڳ�ͻλ�á�����Ӱ���˲������ܡ�
 * 
 * 
 * ʹ��HashSet��Ŀ���ǿ��ٲ��ң�����Ҫ��дequals��hashCode������Ҫ��֤����������һ���ԡ�
 * 
 * */
public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<Object> book = new HashSet<>();
		
		book.add(new A());
		book.add(new A());
		book.add(new B());
		book.add(new B());
		book.add(new C());
		book.add(new C());
		
		System.out.println(book);
	}
	
}

class A{//����ֻ�����1������Ϊ����ɢ�����equals����ͬ
	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}

class B{//�����һ�����������������ʹ��ͬһ��ɢ���룬Ӱ���ѯ����
	@Override
	public int hashCode() {
		return 2;
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
}

class C{//���������������������ڲ�ͬ��λ��
	
}