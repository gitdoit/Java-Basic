package top.seefly.javase.jvm.gc;

/**
 * 通过虚拟机参数查看使用那个垃圾收集器
 * -XX:+PrintCommandLineFlags
 *  ——》》》  -XX:InitialHeapSize=261356160 -XX:MaxHeapSize=4181698560 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
 * 在java8里，默认使用ParallelGC，这个是新生代用的垃圾回收器，默认配合Parallel Old GC管理老年代
 *
 *
 * 堆设置的太小 垃圾收集器会变成串行的
 * @author liujianxin
 * @date 2021/3/30 22:06
 */
public class UseWitchGC {
    
    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}
