package top.seefly.javase.old2017.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 判断一个手机号是否是以136开头的后跟6或8的11位合法手机号码
 * 判断一个邮箱是否符合规则：seefly@vip.qq.com
 * 					413917463@qq.com
 * 以数组或字母开头的一段字符，后跟@后跟域名，以com结尾
 *
 */
public class MatchesDemo2 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input you PhoneNumber!");
        String number = in.nextLine();
        System.out.println(matchesMail(number));
    }
    
    //判断手机号
    public static boolean matchesNumber(String number) {
        return number.matches("(136)[68]\\d{7}");
    }
    
    public static boolean matchesMail(String mail) {//([a-z]|\\d) {0,}@[a-z] {0,}\\.{0,}\\.(com)$"
        //String regex = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,}(\\.[a-zA-Z_0-9]{2,6})+";
        String regex = "\\w+@\\w{2,}(\\.\\w{2,6})+";//     \\w等同于[a-zA-Z_0-9]
        return mail.matches(regex);                    //     \\W等同于[^\\w]
    }
}
