package top.seefly.javase.old2017.mypraxis;

import java.io.File;

/*
 * 将某文件夹下所有满足条件的文件更名。
 */
public class IOTest1 {

    public static void main(String[] args) {
//			File file = new File("e:\\学习资料");
//			File[] fileArr = file.listFiles();
//			String[] name = file.list();
//			int i = 1;
//			for(File e : fileArr) {
//				e.renameTo(new File(file,"视频"+ i++));
//			}

        File file = new File("e:\\学习资料");
        File[] fileArr = file.listFiles();//子文件夹目录列表
        for (int i = 0; i < fileArr.length; i++) {//遍历各个子文件夹
            File[] chaiFile = fileArr[i].listFiles();//取出子文件夹中所有文件
            File[] ccFile = chaiFile[0].listFiles();//提取子文件夹中第一个文件中所有文件
            String name = ccFile[0].getName().substring(0, 2);//提取孙文件夹中第一个文件名的前两个字符
            fileArr[i].renameTo(new File(file, name));
            //System.out.println(new File(file,name).getAbsolutePath());

        }

    }

}
