package top.seefly.javase.old2017.io;
/*
 * 该流也称为内存流，即不会将数据写入文件中，而是在内存中开辟一个缓冲池，在写的时候将数据写入该缓冲池，程序结束，数据丢失。
	且不用使用close方法
 * 
 * 
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//不用指定目标
        for (int i = 0; i < 10; i++) {
            baos.write(("刘建鑫").getBytes());//getBytes()使用平台默认编码（本机GBK），将字符串转换成byte数组。write()将byte数组存入缓冲区
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());//数据源为内存缓冲区。
        byte[] bt = new byte[2];//GBK编码表：字母数字使用一个字节，中文使用两个。因为缓冲池中全部为中文，所以指定byte数组长度为2.若中英文都有，会出问题
        while (bais.read(bt) != -1) {
            System.out.println(new String(bt));//使用平台默认解码（本机GBK），将byte解码成字符串
        }
    }

}
