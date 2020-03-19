package top.seefly.javase.old2017.net_udp;
/*2017年7月24日
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {

    public static void main(String[] args) throws IOException {
        //new一个socket对象
        DatagramSocket ds = new DatagramSocket();
        String str = "";
        byte[] bt = new byte[1024];
        //输入流指向键盘
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("你：");
            //从键盘得到字符串
            str = input.readLine();
            bt = str.getBytes();
            //数据打包
            DatagramPacket pg = new DatagramPacket(bt, bt.length, InetAddress.getByName("192.168.3.4"), 10086);
            //发送
            ds.send(pg);

        } while (!str.equals("close"));
        input.close();
        ds.close();
    }

}
