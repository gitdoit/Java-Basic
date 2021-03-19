package top.seefly.javase.old2017.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class BufferedInputStreamDemo {
    
    public static void main(String[] args) throws IOException {
        BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("e:\\liujianxin.txt"));
        byte[] bt = new byte[8];//虽然使用了缓冲池，但也要为底层的流提供一个缓冲数组
        //		while(bfis.read(bt) != -1)
        //			System.out.println(new String(bt));
        int by;
        while ((by = bfis.read()) != -1) {
            System.out.println((char) by + ":" + by);
        }
        bfis.close();
        
    }
    
}
