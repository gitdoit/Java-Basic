package top.seefly.javase.old2017.net_tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * 本类用来上传文件到服务器
 * 多个地方都要抛异常的话，建议针对每个地方都做对应的处理，或者使用对应的异常接收
 */
public class UploadClient {
    
    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("192.168.3.4", 8888);
        //从文件读数据
        BufferedInputStream input = new BufferedInputStream(new FileInputStream("e:\\IOTest\\httpclient.pdf"));
        //向管道写数据
        BufferedOutputStream output = new BufferedOutputStream(sk.getOutputStream());
        byte[] bt = new byte[1024];
        int len;
        while ((len = input.read(bt)) != -1) {
            output.write(bt, 0, len);
            //带缓冲的都要刷新一下
            output.flush();
        }
        //************通知服务器上传完毕，没有要写的了******************** //
        sk.shutdownOutput();
        //建立管道读入
        BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        //从管道读入显示,in.readLine()不能直接放进System.out.println(),会出问题，不知道为什么
        String str = in.readLine();
        System.out.println(str);
        //关闭文件通道
        input.close();
        //关闭客户端
        sk.close();
    }
    
}
