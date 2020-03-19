package top.seefly.javase.old2017.mypraxis;

public class CopyPicture {
    public static void main(String[] args) {
        int x, y, z, count = 0;
        for (x = 0; x <= 5; x++)
            for (y = 1; y <= x; y++)
                for (z = 1; z <= y; z++)
                    count++;
        System.out.println(count);
    }
}
