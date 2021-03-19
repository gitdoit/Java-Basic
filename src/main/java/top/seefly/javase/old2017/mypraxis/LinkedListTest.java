package top.seefly.javase.old2017.mypraxis;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {//链表，适合大量的增删。不适合查找
    
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("i'am");
        list.add("the");
        list.add("best");
        list.add("man");
        list.add("in");
        list.add("world");
        ListIterator<String> litr = list.listIterator();
        
        List<String> list1 = new LinkedList<>();
        list1.add("刘建鑫");
        list1.add("是");
        list1.add("世界上");
        list1.add("最");
        list1.add("帅的人");
        ListIterator<String> litr1 = list1.listIterator();
        
        while (litr.hasNext()) {
            if (litr1.hasNext()) {
                litr.add(litr1.next());
            }
            litr.next();
        }
        //System.out.println(list);
        for (String e : list) {
            System.out.print(e);
        }
        
        
    }
    
}
