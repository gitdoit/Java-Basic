package top.seefly.javase.old2017.mypraxis;

import java.io.File;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

/*
 * 问题：将指定文件内的敏感词汇和谐成*
 * 思路：敏感词汇长度不固定，内容不固定，若采用循环匹配则效率极低。
 * 敏感词汇录入敏感词汇库，那怎么从字符串中准确找到敏感词汇呢？
 * 我觉得可以使用多级映射！
 * 		一级映射：存储敏感单词首字符，使用HashSet
 * 		二级映射：存储敏感单词长度为2,或更长敏感词的前两个字符.使用HashSet
 * 		三级映射：存储敏感单词长度为3的单词，这里只考虑敏感单词长度最多为3。使用HashSet
 * 遍历各个判断各个字符，进行一级映射。若为敏感单词首字符，则从字符串中取从此字符开始的两个字符进行二级映射。若无，则跳过，若有则进行三级映射。三级映射若无，则屏蔽
 * 这两个字符，若有则屏蔽这三个字符。
 * 今天我看见一个人超级牛逼，我操你妈的，怎么这么牛逼，习近平看了都觉得牛逼的不行！共产党都觉得屌！牛逼
 */
public class HexieTest {

    public static void main(String[] args) throws IOException {
        double startima = System.currentTimeMillis();
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\IOTest\\src.txt")));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\IOTest\\tar.txt")));
        BufferedReader input1 = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\IOTest\\敏感词库.txt")));
        StringBuffer words = new StringBuffer();
        String str1 = null;
        while ((str1 = input.readLine()) != null) {//待比较文件读入进words缓存数组
            words.append(str1);
        }
        //System.out.println(words);
        input.close();
        HashSet<String> base = new HashSet<>();
        HashSet<String> mid = new HashSet<>();
        HashSet<Character> top = new HashSet<>();
        //录入敏感词汇，此操作应为用户操作。完善功能后可以批量操作
//		base.add("牛逼");
//		base.add("傻逼");
//		base.add("操你妈");
//		base.add("习近平");
//		base.add("共产党");
        while ((str1 = input1.readLine()) != null) {//敏感词库存入base
            base.add(str1);
        }

        //提取敏感词汇首字符和前两个字符，此操作应为自动操作
        Iterator<String> it = base.iterator();
        String str = null;
        while (it.hasNext()) {
            str = it.next();
            top.add(str.charAt(0));
            mid.add(str.substring(0, 2));
        }
        //System.out.println(mid);
        //遍历字符串
        int index;
        for (index = 0; index < words.length(); index++) {//还要做修改，
            if (top.contains(words.charAt(index)) && index < words.length() - 1) {//包含，且不是最后一个字符
                if (mid.contains(words.substring(index, index + 2))) {
                    if (index < words.length() - 2 && base.contains(words.substring(index, index + 3))) {
                        words.replace(index, index + 3, "***");
                    } else {
                        words.replace(index, index + 2, "**");
                    }
                }
            }

        }
        String str2 = words.toString();
        output.write(str2);
        output.close();
        System.out.println(System.currentTimeMillis() - startima);


    }

}
