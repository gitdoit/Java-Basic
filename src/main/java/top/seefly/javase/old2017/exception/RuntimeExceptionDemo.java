package top.seefly.javase.old2017.exception;

/*RuntimeException和Error异常都是免检异常，即可以不使用try-catch块来做专门处理
 * 即使是在方法内手动抛出，方法头部也不用声明。使用该方法的函数也不用try
 *
 * 自定义异常：如果异常发生致使程序无法再运行则定义运行时异常
 * */
public class RuntimeExceptionDemo {
    
    public static void main(String[] args) {
        System.out.println();
    }
    
    
}

class Demo {
    
    static int div(int a, int b) //throws ArithmeticException 是否在函数头部这样声明引用它的地方都不必做try处理
    {
        if (b == 0) {
            throw new ArithmeticException("不能除0");//即使手动抛出也不用再头部声明，再引用的地方做针对性处理
        }
        return a / b;
    }
}
