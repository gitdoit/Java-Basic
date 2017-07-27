package regex;

public class ReplaceDemo {

	public static void main(String[] args) {
		String src = "23423hjhj2342lkj23423";
		String tar = src.replaceAll("\\d+", "+");
		System.out.println(tar);
	}

}
