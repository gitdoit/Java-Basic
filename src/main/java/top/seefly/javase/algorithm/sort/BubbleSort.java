package top.seefly.javase.algorithm.sort;

/**
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 * 冒泡排序
 * @author liujianxin
 * @date 2019/9/15 20:11
 */
public class BubbleSort {
    public static void main(String[] p) {
        int[] arr = {1,7,4,2,7,5,3,9,0};
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr.length - i -1 ; j++){
                // 比较相邻两个元素的大小，后一个比前一个小，则调换一下位置
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }
}
