package top.seefly.javase.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 虚拟机参数
 *
 * -Xms 初始堆大小
 * -Xmx 堆最大大小
 * -Xmn 新生代大小
 * -XX:InitialSurvivorRatio=ratio 动态幸存区比例
 * -XX:SurvivorRatio=ratio 幸存区比例
 * -XX:MaxTenuringThreshold=15 晋升阈值
 * -XX:+PrintTenuringDistribution 晋升详情
 * -XX:+PrintGCDetails -verbose:gc GC详情
 * -XX:+ScavengeBeforeFullGC FullGC前 MinorGC
 *
 *
 * @author liujianxin
 * @date 2021/3/25 20:31
 */
public class ShowGC {
    
    private static final int _512KB = 1024 * 512;
    private static final int _1M = 1024 * 1024;
    private static final int _6M = 1024 * 1024 * 6;
    private static final int _7M = 1024 * 1024 * 7;
    private static final int _8M = 1024 * 1024 * 8;
    
    /*
    *
    * 堆日志解读
    * Heap
    *    // 新生代                 9m=eden+from
    *     def new generation   total 9216K, used 8143K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
    *       //eden区8m
    *       eden space 8192K,  90% used [0x00000000fec00000, 0x00000000ff33d8c0, 0x00000000ff400000)
    *       // from 1m
    *       from space 1024K,  71% used [0x00000000ff500000, 0x00000000ff5b6710, 0x00000000ff600000)
    *       // to 1m
    *       to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
    *    // 老年代              10m=堆总大小-新生代大小
    *     tenured generation   total 10240K, used 0K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
    *       the space 10240K,   0% used [0x00000000ff600000, 0x00000000ff600000, 0x00000000ff600200, 0x0000000100000000)
    * gc日志解读
    * [新生代GC (触发原因：分配失败) [新生代：回收前大小->回收后大小(总大小)，使用时间  ]  已用堆大小->回收后大小(堆总大小)，耗费时间]
    * [GC (Allocation Failure)  [DefNew: 2150K->729K(9216K), 0.0015648 secs] 2150K->729K(19456K), 0.0016115 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    *
    *
    * */
    
    // 初始堆=最大堆=20m 新生代10m(则from和to各1m，from和to同时只有一个可用，所以新生代共9m可用)
    // 老年代=堆总大小-新生代大小=10m
    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        list.add(new byte[_7M]);
    }
    
    
}
