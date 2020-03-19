package top.seefly.javase.old2017.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 该类的目的是为数据的输入与输出提供一个缓冲区，像是微机接口中的各种缓冲区。
 * 缓冲区的实现对程序的工作效率提升非常高。
 * 而缓冲区的构造方法是需要提供一个底层的输入/输出流对象（InputStream/OutputStream）。这说明该类并不是直接用来传输数据的，而是提供了一个缓冲池。
 * 该缓冲池的构造方法有两种一般，可设定是否指定缓冲池大小，但一般都不指定，默认即可。
 *
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
//		FileOutputStream fos = new FileOutputStream("e:\\liujianxin.txt");
//		BufferedOutputStream bfos = new BufferedOutputStream(fos); 第一中创建方式

        BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("e:\\liujianxin.txt"));//匿名内部对象
        bfos.write("宇宙无敌超级叼".getBytes());
        bfos.close();//只要关闭缓冲池就可以

    }
}
