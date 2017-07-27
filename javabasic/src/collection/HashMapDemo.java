package collection;
/*
 * HashMap�������ӳ���ϵ������(Key-Values)
 * ����Keyʹ��set�Ĵ洢��ʽ�����Բ�������ֵͬ��
 * ��Values����List�Ĵ洢��ʽ������ͨ��Key��ֵ��������Ԫ�ؿ�����ͬ��
 * <
 * Key��ֵ����ΪNull,��Ҳֻ����һ��key��ֵ��null
 * 
 * HashMpy�̲߳���ȫ
 * */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import employee.Employees;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String,Employees> staff = new HashMap<>();
		staff.put("2016120074",new Employees("liujianxin") );
		staff.put("2016120075", new Employees("liuwei"));
		staff.put("2016120076",new Employees("maozedong"));
		System.out.println(staff);
		
		String name;
		if(staff.get("2016120074")!=null)
			name = staff.get("2016120074").getName();
		else
			name = "NoSuchGuy";
		System.out.println("Who's key is 2016120074?---"+name);
		
		staff.remove("2016120074");
		System.out.println("after remove"+staff);
		Set<String> st = staff.keySet();
		//System.out.println(st);
		st.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
	}

}
