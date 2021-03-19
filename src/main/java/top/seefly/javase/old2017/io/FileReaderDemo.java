package top.seefly.javase.old2017.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    
    public static void main(String[] args) throws IOException {
        FileReader frd = new FileReader(new File("writer.txt"));
        char[] ch = new char[1024];
        while (frd.read(ch) != -1) {
            System.out.println(ch);//由于无法指定解码方式，使用的是默认的GBK，而源文件是通过UTF-8编码的。所以出现乱码
        }
        frd.close();
    }
    
}
