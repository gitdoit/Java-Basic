package string;
/*
 * 基本方法
 * */
public class demo2 {
	public static void main(String[] args) {
		String str = new String("hello world!");
		char c = str.charAt(0);
		int a = str.compareTo("hello");
		boolean flag = str.endsWith("world!");
		boolean flag4 = str.startsWith("he");
		boolean flag2 = str.equals("hello world!");
		boolean flag3 = str.equalsIgnoreCase("HELLW WORLD!");
		str = str.toUpperCase();
		str = str.toLowerCase();
		
	}
}
