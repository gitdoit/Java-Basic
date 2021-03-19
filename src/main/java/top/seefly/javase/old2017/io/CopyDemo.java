package top.seefly.javase.old2017.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 本类用来演示从一个文件读，向一个文件写
 */
public class CopyDemo {
    
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("e:\\liujianxin.txt");//文件不存在则报异常
        FileOutputStream fos = new FileOutputStream("e:\\liuyifei.txt");//文件不存在则新建
        
        byte[] byt = new byte[1024];//复制文本演示
        //		while(fis.read(byt) > 0) 这种方法复制会在最后一次复制的时候，如果数组没有填满，那么会将空格也复制进去。
        //			fos.write(byt);
        int len;
        while ((len = fis.read(byt)) != -1) {
            fos.write(byt, 0, len);//使用这种方法，每次都是将数组中有的数据写入，空的不写
        }
        fis.close();
        fos.close();
        
        //		FileInputStream fis1 = new FileInputStream("e:\\laopogif.gif");//字节流复制图片
        //		FileOutputStream fos1 = new FileOutputStream("e:\\laopofuben.gif");
        //		while(fis1.read(byt) != -1)
        //			fos1.write(byt);
        //		fis1.close();
        //		fos1.close();
        
        //复制视频也是一个流程，不做了
    }
    
}
