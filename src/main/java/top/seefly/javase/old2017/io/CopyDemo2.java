package top.seefly.javase.old2017.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 复制文本文件，使用打印流对其增强
 * 从e:\\IOTest\\src.txt到同目录下的tar.txt
 */
public class CopyDemo2 {
    
    public static void main(String[] args) throws IOException {
        //原来的方法
        //		BufferedReader br = new BufferedReader(new FileReader("e:\\IOTest\\src.txt"));
        //		BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\IOTEst\\tar.txt"));
        //		
        //		String str = null;
        //		while((str = br.readLine()) != null) {
        //			bw.write(str);//写入一整行
        //			bw.newLine();//再新建一行
        //			bw.flush();//冲刷一行
        //		}
        //		br.close();
        //		bw.close();
        
        BufferedReader br = new BufferedReader(new FileReader("e:\\IOTest\\src.txt"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("e:\\IOTest\\tar.txt"), true);//设置打印流，且自动冲刷
        //虽然没有明确指明此打印流有缓冲池，但内部已经包装好了
        
        String str = null;
        while ((str = br.readLine()) != null) {
            pw.println(str);//这里一行等同于上面同位置的三行
        }
        br.close();
        pw.close();
    }
    
}
