package top.seefly.javase.algorithm.sort;

/**
 * 选择排序
 *
 * @author liujianxin
 * @date 2019/9/15 19:49
 */
public class SelectionSort {

    public static void main(String[] p) {
        int[] arr = {1, 7, 4, 2, 7, 5, 3, 9, 0};

        for (int i = 0; i < arr.length; i++) {
            // 内循环一次，找到一个未排序元素中最小的下标
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 内环一次结束后，确定一个元素的顺序
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
