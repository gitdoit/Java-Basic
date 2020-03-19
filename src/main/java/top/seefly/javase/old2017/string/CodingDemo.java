package top.seefly.javase.old2017.string;

import java.io.UnsupportedEncodingException;

/*
 * 有多种不同的编码表，各个国家本地的编码表都不同
 * 中国本地默认的是GBK编码表。使用两个字节表示一个中文
 * 美国地区使用的是ASCII编码表，一个字节表示一个英文字母
 * 台湾香港等使用繁体字的地区使用BIG-5编码表
 * 日本使用Shift-JFS
 *
 * 但是这些编码表都仅限于本地使用，所以提出了国际编码表，即一种通用的编码表UTF-8
 * 它【最多】可以使用3个字节表示一个字符，一个字节不够用俩字节，俩不够用仨。
 *
 * 编码：将字符按某种编码表转换成字节
 * 解码：按某种编码表将字节转换成字符
 *
 */
public class CodingDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "刘建鑫";

        byte[] bt = str.getBytes();//使用平台默认的编码表将字符转换成字节，这里是GBK
        String get = new String(bt);//使用默认编码表将字节数组转换成字符
        System.out.println(get);

        bt = str.getBytes("UTF-8");//这里指定了使用UTF-8进行编码
        get = new String(bt);//但是解码却用了默认的GBK，所以出现了乱码
        System.out.println(get);//鍒樺缓閼?


    }

}
