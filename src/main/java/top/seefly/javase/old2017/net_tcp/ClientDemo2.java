package top.seefly.javase.old2017.net_tcp;
/*
 * 本类演示了在客户端从键盘录入数据，发送到服务端，服务端接收到之后写入文件。
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDemo2 {
    
    public static void main(String[] args) throws IOException {
        //指定服务器
        Socket sk = new Socket("192.168.3.4", 8888);
        //包装输出流,向管道写数据
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
        //包装输入流，从键盘读数据
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        //循环从键盘读数据，并向管道内写入
        while ((str = input.readLine()) != null) {
            if (str.equals("close")) {
                break;
            }
            output.write(str);
            //记得冲刷。不然服务器会一直等.
            output.newLine();
            output.flush();
        }
        output.close();
        sk.close();
    }
    
}
