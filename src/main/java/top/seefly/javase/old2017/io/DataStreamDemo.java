package top.seefly.javase.old2017.io;
/*
 * DataInputStream和DataOutputStream分别继承自FileInputStream和FileOutputStrem
 * 并且实现了DataInput和DataOutpu接口
 * 他们使用与平台无关的方法，向文件中读写指定字节长度，并转换成对应的数据类型。
 *
 * 注意，writeXXX和readXXX要对应。系统不会因为你指定了writeInt()就从文件中选取下一段表示int值的字节进行转换。
 * 它只是从上一次读取记录位置开始，根据指定的方法读取指定的字节根据UTF-8修改版编码表进行转换。
 *
 *
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DataStreamDemo {
    
    public static void main(String[] args) throws IOException {
        
        writer();
        reader();
    }
    
    public static void writer() throws IOException {
        DataOutputStream dop = new DataOutputStream(new FileOutputStream("e:\\IOTest\\datatest.txt"));//操作数据流
        dop.writeChar(65);//写入两个字节。存储char
        dop.writeInt(33);//写入八个字节，存储int值
        dop.writeDouble(77);//写入8个字节，存储double值
        dop.writeUTF("刘建鑫");//使用与机器无关的方式，向文件写入一段字节串，该串开头使用两字节表示字符长度。对应的readUTF可以解读。
        dop.close();
    }
    
    public static void reader() throws IOException {
        DataInputStream dip = new DataInputStream(new FileInputStream("e:\\IOTest\\datatest.txt"));
        byte[] bt = new byte[2];//从文件中读取2个字节，并使用指定的解码方式转换成字符串
        dip.read(bt);
        String str = new String(bt, "GBK");//若不指定解码方式，将会选用平台默认
        System.out.println(str);
        
        System.out.println(dip.readInt());//从文件中那个读取8个字节，转换成int
        System.out.println(dip.readDouble());//从文件中读取8个字节，转换成double
        System.out.println(dip.readUTF());//从文件中读取一段由UTF-8修改版编码的字符串(详细见DataInput接口)
        dip.close();
    }
    
    
}
