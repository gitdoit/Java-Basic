package top.seefly.javase.old2017.net_tcp;
/*
 * 用来模仿客户端，向服务器发送数据。
 * 若要发送数据，一定要先开启服务器，接收数据。否则报错
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("192.168.3.4", 8888);
        //获取管道输出接口，将从此管道发送数据。
        OutputStream out = sk.getOutputStream();
        //发送数据
        out.write("刘建鑫".getBytes());
        //获取管道输入接口，准备从此管道接收数据
        InputStream in = sk.getInputStream();
        byte[] mes = new byte[1024];
        int len = in.read(mes);//在服务器没有发送数据到客户端之前，此方法都会造成阻塞
        System.out.println(new String(mes, 0, len));
        out.close();
    }

}
