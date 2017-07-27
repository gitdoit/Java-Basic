package testpackage;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public	class TestClass {
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		double before= System.currentTimeMillis();
		for(int i = 0; i < 100000000; i++) {
			BigDecimal d = new BigDecimal("0");
		}
		double after =System.currentTimeMillis();
		System.out.println(after-before);
		before=System.currentTimeMillis();
		BigDecimal d;
		for(int i=0;i<100000000;i++){
			d=new BigDecimal("0");
		}
		after=System.currentTimeMillis();
		System.out.println(after-before);
		
		
	}
}

class Demo{
	
}

