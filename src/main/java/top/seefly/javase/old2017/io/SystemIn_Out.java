package top.seefly.javase.old2017.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * public static final InputStream in  “标准”输入流。
 * public static final PrintStream out “标准”输出流。
 *
 */
public class SystemIn_Out {
    
    public static void main(String[] args) throws IOException {
        //静态方法，打印流。为PrintStream
        System.out.println("hello world!");
        
        //与上面等价，目标为显示器
        PrintStream ps = System.out;
        ps.println("hello world!");
        
        Scanner in = new Scanner(System.in);//这里传入的参数是InputStream类型。即字节流
        String str = in.nextLine();//之前一直都是这样使用，从键盘读入数据，一次读一行
        
        //使数据源指向键盘录入，即从从前的从文件中读数据，变成现在的从键盘读数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1;
        
        str1 = br.readLine();
        ps.println(str1);
        ps.println(str);
        ps.close();
        br.close();
        in.close();
        
    }
    
}
