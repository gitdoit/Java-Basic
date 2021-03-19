package top.seefly.javase.old2017.regex;
/*
 * 按照给定的正则表达式将给定的字符串拆分成n个字符串，并返回一个字符串数组
 *
 */

import java.util.Arrays;

public class SplitDemo {
    
    public static void main(String[] args) {
        String knights =
                "Then,when you have found the shrubbery,you must " + "cut down the mightiest tree int hte forest..."
                        + "with..a herring!";
        String[] str = knights.split(" ");//按空格方式切分,
        
        String condition = "18-24";
        String[] str1 = condition.split("-");
        
        String src = "liu    jian    xin";
        String[] str2 = src.split(" ");//按一个空格方式进行切分
        for (int i = 0; i < str2.length; i++) {
            System.out.println(i + ":" + str2[i]);
        }
        
        String[] str3 = src.split(" +");//按一个或多个空格方式切分
        for (String e : str3) {
            System.out.println(e);
        }
        
        String src1 = "E:\\学习资料\\正则\\avi";
        String[] str4 = src1.split("\\\\");//注意，java中的\代表转义的意思，\\则代表我们认为的'\'。所以'\\'应该用\\\\表示
        for (String e : str4) {
            System.out.println(e);
        }
        
    }
    
}
