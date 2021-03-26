package top.seefly.javase.jvm.memorymodel;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author liujianxin
 * @date 2021/3/23 17:11
 */
public class OOMMetaSpace extends ClassLoader {
    
    /**
     * 演示撑爆方法区
     * 在HotSpot中，方法区用元空间实现，放在堆外使用本地内存，只要系统内存足够大，不会被撑爆；
     * 但是可以使用 -XX:MaxMetaspaceSize=8m 来限制
     */
    public static void main(String[] args) {
        int j = 0;
        try{
            OOMMetaSpace load = new OOMMetaSpace();
            for (int i = 0; i < 10000; i++,j++) {
                ClassWriter cw = new ClassWriter(0);
                cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class" + i,null,"java/lang/Object",null);
                byte[] code = cw.toByteArray();
                load.defineClass("Class"+i,code,0,code.length);
            }
        }catch (Throwable t){
            // java.lang.OutOfMemoryError: Compressed class space
            // 奇怪，人家都是 java.lang.OutOfMemoryError: Metaspace，我的怎么是这个？
            t.printStackTrace();
        }finally {
            // 1251
            System.out.println(j);
        }
    }
    
    
}
