package top.seefly.javase.old2017.exception;

/*
 * 该类演示了一个catch块可以捕获多个异常，但是此时的参数ex被修饰为fianl。无法对其进行重新赋值
 * */
public class MultiExceptionDemo {
    public static void main(String[] args) {
        try {
            String[] arrStr = {"32", "44", "334"};
            int a = Integer.parseInt(arrStr[0]);
            int b = Integer.parseInt(arrStr[1]);
            int c = a / b;
        } catch (IndexOutOfBoundsException | NumberFormatException | ArithmeticException ex) {
            //ex = new IndexOutOfBoundsException();
            //多异常捕获时，ex被默认修饰为final。所以无法对其进行重新赋值；
        } catch (Exception ex) {
            ex = new IndexOutOfBoundsException();
        }
    }

}
