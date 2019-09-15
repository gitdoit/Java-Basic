package top.seefly.javase.old2017.string;
/*
 * 该类演示了字符串的截取与拼接
 * substring(begaindex,enddex);
 * substring(begaindex);
 * 
 * 字符串常量是放在存储池中共享的
 * */
public class Demo1 {
	public static void main(String[] args) {
		String str = "Hello";//Hello是不可变的，但是str是可变引用
							//若有另一个引用也指向Hello那么并不会开辟新空间
		String s = str.substring(0,3);//截取0，1，2
		String s1 = str.substring(2);//截取从2开始,包括2
		
		
		String demo = s + s1;//字符串可以使用+拼接
		demo = str + " world";
		
		boolean flag = demo.equals(str);//比较两个字符串中的内容相等否
										//不能使用==，因为它比较的是地址
		
	}
}
