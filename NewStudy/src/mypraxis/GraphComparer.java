package mypraxis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GraphComparer {

	public static void main(String[] args) throws IOException {
		File src = new File("e:\\liujianxin.txt");
		File tar = new File("e:\\liuyifei.txt");
		FileInputStream input = new FileInputStream(src);
		FileInputStream input1 = new FileInputStream(tar);
		
		int tmp,tmp1 = 0;
		while((tmp = input.read()) !=-1 && (tmp1 = input1.read()) != -1){
			//System.out.println((char)tmp +"   " + (char)tmp1);
			if((tmp ^ tmp1) > 0) {
				System.out.println("不等");
				break;
			}
		}
		if(tmp != tmp1)
			System.out.println("不等");
		System.out.println("等");
		input.close();
		input1.close();

	}

}
