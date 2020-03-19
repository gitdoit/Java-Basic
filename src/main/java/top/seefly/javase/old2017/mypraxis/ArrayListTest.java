package top.seefly.javase.old2017.mypraxis;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {//可扩展数组，底层由数组实现，线程不安全，效率高。适合随机访问，不适合插入删除。

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("is");
        list.add("good");

        ListIterator<String> itr = list.listIterator();

        String str;
        while (itr.hasNext()) {
            str = itr.next();
            if (str != null && str.equals("good"))
                itr.add("javaee");
        }
        System.out.println(list);
    }

}
