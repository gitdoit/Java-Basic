package top.seefly.javase.old2017.testpackage;

public class Test {
    public static void main(String[] args) throws ReflectiveOperationException, Exception {
        Integer a = new Integer(5);
        set(a);
        System.out.println(a);

    }

    public static void set(Integer a) {
        a = 10;
    }
}
