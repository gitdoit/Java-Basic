package top.seefly.javase.old2017.regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 将指定的正则表达式包装成模式，使用此模式与字符串进行比较
 */
public class PatternDemo {

	public static void main(String[] args) {
		//将模式编译成对象
		Pattern p = Pattern.compile("a*b");//*代表一次或多次
		//通过模式对象，得到匹配器对象
		Matcher m = p.matcher("aaab");
		//通过匹配器中的各种方法，完成各种操作
		System.out.println(m.matches());//这两句等同下与下面语句
		//System.out.println(p.matcher("aaaab").matches());
		
		//将字符串中满足要求的子序列抽取出来，组成一个字符串数组
		String str = "lao zi jin tian hen kai xin,wo jiu yao qu gan liang bei";
		ArrayList<String> list = new ArrayList<>();
		Pattern p1 = Pattern.compile("\\b\\w{3}\\b");//包装规则：单词由三个字母组成的,注意\\w{3}是包含三个字符。必须限定边界
		Matcher m1 = p1.matcher(str);//传入目标字符串
		while(m1.find()) {//找到与规则匹配的自序列
			list.add(m1.group());//将之取出。注意！！在调用group之前一定要先调用find，不然会报错
		}
		System.out.println(list);
	}

}
