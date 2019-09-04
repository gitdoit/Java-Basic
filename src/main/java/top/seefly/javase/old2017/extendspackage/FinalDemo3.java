package extendspackage;
/*
 * ���ڲ��ɱ�ʵ����ʹ�������ǳ����㣬������ʱ���ھ���ʹ�õ���ʱ���ظ�new��ͬ�Ķ����ϵͳ��
 * �����ǳ������Կ���ʹ�û���������������⣬����������Ѿ�����������ʱ����Բ�����new
 * */
public class FinalDemo3 {
	
	
	public static void main(String[] args) {
		Cache a = Cache.valueOf("liu");
		Cache b = Cache.valueOf("liu");
		Cache c = Cache.valueOf("zhang");
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		//System.out.println(Cache.getPos());
		
	}
	

}

class Cache{
	private static int MAX_SIZE = 10;//�����
	private static Cache[] cache = new Cache[MAX_SIZE];//������������
	private static int pos;//�����
	private final String name;//���ɱ�������
	
	private Cache() {//�޲ι���
		this.name = "";
	}
	private Cache(String name) {//�вι���
		this.name = name;
	}
	public String getName() {//������
		return this.name;
	}
	public static int getPos() {
		return pos;
	}
	public static Cache valueOf(String name){//�õ�һ����name��ͬ�Ķ���
		for(int i = 0;i < MAX_SIZE;i++)
			if(cache[i] != null && cache[i].getName().equals(name))
				return cache[i];
		if(pos == MAX_SIZE)
			pos = 0;
		cache[pos++] = new Cache(name);
		return cache[pos - 1];
	}
	
	@Override
	public boolean equals(Object cc) {//��дequals����
		if(this == cc)
			return true;
		if(cc != null && cc.getClass() == this.getClass()) {
			Cache c = (Cache)cc;
			if(this.getName().equals(c.getName()))
				return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.getName().hashCode()*31;
	}
}