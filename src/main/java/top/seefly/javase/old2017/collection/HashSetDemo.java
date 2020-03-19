package top.seefly.javase.old2017.collection;

import java.util.HashSet;

/*
 * set是指无序的意思，类似一个罐子，罐子内的元素必须各不相同(equals,hashCode)。他们之间没有顺序。
 * 如何判断两个元素是否相同？
 * 	根据该元素的equals，hashCode方法
 * 	如果两个元素通过equals方法比较相同，但hashCode方法返回值不同，那么还是会将该元素放入罐子内，根据hashCode返回值分配位置
 * 	但是如果两个元素equals比较不同，但是hashCode方法返回值相同，那么会将该元素同过链表形式挂在冲突位置。这样影响了查找性能。
 *
 *
 * 使用HashSet的目的是快速查找，所以要重写equals，hashCode方法。要保证两个方法的一致性。
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

class A {//该类只能添加1个，因为返回散列码和equals总相同

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class B {//该类和一添加无数个，但都会使用同一个散列码，影响查询性能

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

class C {//该类可以添加无数个，都在不同的位置

}