package top.seefly.net;

import org.junit.Test;
import top.seefly.javase.net.tcp.ClientDemo;
import top.seefly.javase.net.tcp.ServerDemo;

import java.util.Scanner;

/**
 * @author liujianxin
 * @date 2019-01-04 14:17
 */
public class TCPTest {

    @Test
    public void testStartServer() {
        ServerDemo serverDemo = new ServerDemo();
        serverDemo.start(8899);
    }


    public static void main(String[] args) {
        ClientDemo clientDemo = new ClientDemo("127.0.0.1", 8899);
        Scanner s = new Scanner(System.in, "UTF-8");
        String l;
        while ((l = s.nextLine()) != null) {
            clientDemo.sendMes(l);
            if ("bye".equals(l)) {
                break;
            }
        }
    }

}
