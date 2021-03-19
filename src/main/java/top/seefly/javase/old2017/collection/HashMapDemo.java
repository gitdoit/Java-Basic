package top.seefly.javase.old2017.collection;
/*
 * HashMap保存具有映射关系的数据(Key-Values)
 * 其中Key使用set的存储形式，所以不能有相同值。
 * 而Values像是List的存储形式，可以通过Key的值来索引，元素可以相同。
 * <
 * Key的值可以为Null,但也只能有一个key的值是null
 *
 * HashMpy线程不安全
 * */

import top.seefly.javase.old2017.employee.Employees;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;


public class HashMapDemo {
    
    public static void main(String[] args) {
        Map<String, Employees> staff = new HashMap<>();
        staff.put("2016120074", new Employees("liujianxin"));
        staff.put("2016120075", new Employees("liuwei"));
        staff.put("2016120076", new Employees("maozedong"));
        System.out.println(staff);
        
        String name;
        if (staff.get("2016120074") != null) {
            name = staff.get("2016120074").getName();
        } else {
            name = "NoSuchGuy";
        }
        System.out.println("Who's key is 2016120074?---" + name);
        
        staff.remove("2016120074");
        System.out.println("after remove" + staff);
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
