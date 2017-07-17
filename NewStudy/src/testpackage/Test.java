package testpackage;

import java.util.concurrent.*;


public class Test {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
		System.out.println("cun 数之前");
		try {
			queue.add("d");
			//queue.add("dd");
			//queue.remove("ddt");
			//System.out.println(queue.p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("取数之后");
	}
}

