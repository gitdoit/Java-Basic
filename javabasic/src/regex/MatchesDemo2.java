package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * �ж�һ���ֻ����Ƿ�����136��ͷ�ĺ��6��8��11λ�Ϸ��ֻ�����
 * �ж�һ�������Ƿ���Ϲ���seefly@vip.qq.com
 * 					413917463@qq.com
 * ���������ĸ��ͷ��һ���ַ������@�����������com��β
 * 
 */
public class MatchesDemo2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input you PhoneNumber!");
		String number = in.nextLine();
		System.out.println(matchesMail(number));
	}
	//�ж��ֻ���
	public static boolean matchesNumber(String number) {
		return number.matches("(136)[68]\\d{7}");
	}
	
	public static boolean matchesMail(String mail) {//([a-z]|\\d) {0,}@[a-z] {0,}\\.{0,}\\.(com)$"
		//String regex = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,}(\\.[a-zA-Z_0-9]{2,6})+";
		String regex = "\\w+@\\w{2,}(\\.\\w{2,6})+";//     \\w��ͬ��[a-zA-Z_0-9]
		return mail.matches(regex);					//     \\W��ͬ��[^\\w]
	}
}
