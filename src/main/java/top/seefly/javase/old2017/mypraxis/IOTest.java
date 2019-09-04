package mypraxis;
/*
 * 我的思路。
 * 判断某盘下是否有某文件，这需要遍历整个盘。
 * 因为不同文件夹下的文件数子文件夹不一样，以及深度都不同。所以我想到了递归遍历
 * 这可以用图的深度遍历或者广度遍历。
 */
import java.io.File;

public class IOTest {

	public static void main(String[] args) {
		File file = new File("e:\\");
		File[] FileArr = file.listFiles();
		DFS(FileArr);
		
	}
	
	public static void DFS(File[] file) {
		for(File e:file) { 
			if(e.isDirectory()) {
				File[] chilFile = e.listFiles();
				if(chilFile != null)//E盘根目录下隐藏文件夹，用于恢复系统->system volume information，无判断条件会空指针
					DFS(chilFile);
			}
			
			else {
				if(e.getName().endsWith(".java")) {
					System.out.println("所查文件在:"+e.getAbsolutePath());
				}
			}
		}
	}

}

