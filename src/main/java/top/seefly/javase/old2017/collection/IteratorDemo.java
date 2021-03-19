package top.seefly.javase.old2017.collection;
/*
 * 迭代的概念是依附与Collection和Map。脱离的它就没有迭代这个概念,即迭代器不能自我生成
 * 所以迭代器的实例只能从集合对象中取，所有Collection实例中都含有迭代方法Iterator，因为此方法定义在Collection中，子类含有此方法的针对版
 * 在迭代过程中集合不能发生改变，除非使用迭代器的remove方法。使用集合的remove方法会抛出异常
 * hasNext方法只会检测有无下个元素，不会改变迭代链表指针。即指针不会后移
 * 只有调用next方法才会是指针后移，且会返回指针跨过的哪个元素
 *
 * 无序集合HashSet中的迭代，只能从中remove 不能添加
 * 链表集合LinkedList中的ListIterator迭代器，可以在迭代过程中向链表插入元素,可以指针前移
 * 注意：任何迭代器都不能连续两次调用remove，remove的出现都要有对应的next。且在这两个方法中间不能对
 *
 *
 * Iterator接口中定义了三个抽象方法,和一个构造方法
 * Collection接口继承了Iterator接口
 * List接口继承了Collection接口
 * ArrayList 实现了 List 接口
 * 所以ArrayList类实现了Iterator接口中的三个方法，和一个构造方法
 * 此三个方法被实现在它的内部类Itr中。
 * ArrayList.Iterator返回Itr的实例
 * */

import java.util.*;

public class IteratorDemo {
    
    public static void main(String[] args) {
        Collection<String> book = new HashSet<String>();
        book.add("刘建鑫");
        book.add("真帅");
        book.add("这是真的");
        book.add("这没话说");
        book.add("dd");
        Iterator itr = book.iterator();
        while (itr.hasNext()) {                            //hasNext方法只会检测有没有下一个元素，不会使迭代指针后移
            //System.out.println(itr.next());			只有next方法才会使迭代指针后移，所以不要再一次循环中调用两次next方法，
            if (itr.next()
                    .equals("dd"))                    //像是上面的输出语句和这条判断语句使用了两次next则在while循环中会出现NoSuchElementException
            {
                itr.remove();                            //因为迭代器会生成一个链表指针指向原集合，且元集合发生了改变时链表依旧不会改变指向。所以在使用此方法使，元集合不能发生改变，否则异常
            }
            //book.remove("刘建鑫");迭代时，集合不能发生改变。若要改变，只能使用迭代器的remove方法
        }
        System.out.println(book);
        
        List<String> list = new LinkedList<>();            //此集合是有序的，适合任意位置上的插入与删除
        list.addAll(book);                                //初始化集合
        
        ListIterator<String> lit = list.listIterator();//新建链表迭代器，此迭代器比是链表的特有迭代器，新增add/previous功能。一旦集合有了迭代器，此集合不允许自行改变
        System.out.println("next:" + lit.next());
        //list.add(0,"see");							在迭代过程中不能通过链表本身的方法改变链表结构
        System.out.println("next:" + lit.next());
        list.set(0, "best");                            //在迭代中虽然不能更改集合结构，但却可以改变集合指定位置上的内容。
        lit.add("see");                                    //此时经过两次next操作，所以see被添加在链表的第二个位置之后
        System.out.println("previous:" + lit.previous());
        ;//此方法与next方法正好相反，它会使指针前移，并返回指针跨的元素
        lit.add("fly");
        
        //System.out.println(list);
        for (String e : list) {                            //任何实现了Iterator接口的类都能使用for each循环遍历
            System.out.print(e);
        }
    }
    
}
