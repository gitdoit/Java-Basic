package top.seefly.javase.old2017.net_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        String strMes = "";
        //新建socket对象
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] bytMes = new byte[1024];
        //空包用来接数据
        DatagramPacket pg = new DatagramPacket(bytMes, 1024);

        do {
            //接收数据
            ds.receive(pg);
            //解码
            strMes = new String(pg.getData(), 0, pg.getLength());
            //显示
            System.out.printf("form %s message:%s/n", pg.getAddress().getHostName(), strMes);
        } while (!strMes.equals("close"));
        ds.close();
    }
}
