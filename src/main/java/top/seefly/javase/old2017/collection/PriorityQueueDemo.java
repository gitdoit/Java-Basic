package top.seefly.javase.old2017.collection;

import java.util.GregorianCalendar;
/*
 * 该类实现了Queue接口
 * 该类是按照元素优先级来的
 * 内部是按照优先级建的顶堆
 * 每次删除并不是删除队头元素，而是删除优先级最小的元素。
 * 所以该队列用来执行优先级调度，总是执行该队列中优先级最大的任务
 * 队列内的元素都要具有可比性，即实现了Comparable方法
 * 或者为其指定比较器
 * */
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(1);
        queue.add(6);
        queue.add(8);
        queue.add(4);
        //System.out.println(queue);打印 1 4 6 8 4 可见，它只移动了一个元素到顶部。其他的没有排序
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());//打印 14468
        }
    }
}
