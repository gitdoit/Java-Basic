package top.seefly.javase.sort;

/**
 * @author liujianxin
 * @date 2019/9/15 17:12
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,7,4,2,7,5,3,9,0};

        for(int i = arr.length ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] < arr[j]){
                    int temp  = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
