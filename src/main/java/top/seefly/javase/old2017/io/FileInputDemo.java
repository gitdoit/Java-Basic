package top.seefly.javase.old2017.io;
/*
 * IO流的分类
 * 	流向：
 * 		输入流：流向程序
 * 		输出流：从程序流出
 * 	数据类型：
 * 		字节流(底层流)
 * 			字节输入流  	超类(abstract) ： InputStream
 * 										----FileInputStream(File f\String filePathName)
 * 			字节输出流 	超类 (abstract)： OutputStream
 * 										----FileOutputStream(File f\String filePathName)
 *
 * 		字符流(转换流)
 * 			字符输入流  超类(abstract) ：Reader
 * 										----InputStreamReader(InputStream in)
 * 			字符输出流  超类(abstract) ：Writer
 * 										----OutputStreamWriter(OutputStream out)
 *
 * 一般在讨论IO的时候，没有指明按那种方式分类，默认为按数据类型分类
 * 注意：一个FileInputStream对象从文件中读数据，如果读完之后在对其调用read，那么将什么都读不出来，因为它的指针已经移动到末尾。
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo {
    
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("e:\\liujianxin.txt");//如果提供源文件不存在，则报FileNotFoundException
        byte[] bt = new byte[2];//缓冲字节数组
        System.out.println("可供下次读取的字节数为：" + fis.available());
        int hasRead;
        //read(bt,starIndex,len),在数组starIndex位置开始写入长度为len个字节。当读取完所有数据时，返回-1
        //read() 无参方法，返回值是一个int，即读取的字节。当读取完所有数据时，返回-1
        while ((hasRead = fis.read(bt)) > 0) {//read(byte[])方法将指定文件以字节流的形式写入byte输出，写入长度是数组长度。返回值是本次写入长度。
            //当读取结束是，返回值为-1
            System.out.print(new String(bt, 0, hasRead));//String(字节数组，默认解码方式，从数组中读取的长度)
        }
        fis.close();
        
        
    }
    
}
