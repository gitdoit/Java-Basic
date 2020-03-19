package top.seefly.javase.old2017.collection;

import java.util.ArrayDeque;
/*
 * ArrayDeque<>实现了Deque<>(双端队列)接口，而这个接口继承了Queue<>接口
 * 
 * 在Queue中定义了如下几个方法
 * 这三个方法会报异常
 * add()添加
 * remove()移除
 * element() 检查
 
 * offer() 添加，返回真假
 * poll()移除，返回对象或null
 * peek 检查，返回对象或null
 * 
 * 因为该类实现了双端队列接口，所以该队列可以在两端插入或删除
 *  抛出异常				特殊值 				抛出异常 			特殊值 
插入 addFirst(e) 		offerFirst(e) 		addLast(e) 		offerLast(e) 
移除 removeFirst() 	pollFirst() 		removeLast() 	pollLast() 
检查 getFirst() 		peekFirst() 		getLast() 		peekLast() 

 * */
import java.util.Queue;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(3);//等效于 queue.add(3);
        queue.add(4);
        queue.addFirst(5);
        queue.addLast(6);
        queue.add(7);
        queue.removeLast();//等效与queue.remove();
        System.out.println(queue);

    }
}
