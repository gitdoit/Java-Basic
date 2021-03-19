package top.seefly.javase.old2017.exception;

import java.util.*;

//基本的异常演示
public class Try {
    
    public static int BaseException(int i, int j) throws Exception {//声明会抛出一个Exception，要在try内执行
        if (j == 0) {
            throw new ArithmeticException("分母不能为零");//该异常是免检异常。可不必再try块内执行。但声明Exception了
        }
        return i / j;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two inteters:");
        int i = 0, j = 0;
        
        try {//由于用到的方法会抛出一个必检异常，所以要在try内执行
            i = input.nextInt();
            j = input.nextInt();
            int result = BaseException(i, j);//如果该方法抛出异常，则不会执行下一条语句，转而进入catch
            System.out.println(result);
        } catch (ArithmeticException ex) {//有异常抛出会被catch抓住
            System.out.println(ex);
        } catch (InputMismatchException ex) {
            
            System.out.println("输入不合法");
            throw ex;//从main函数抛出异常，交由上级处理。
        } catch (Exception ex) {//注意从InputMismatchException抛出的异常不会跑到这里，他们是同级。会从调用它的函数中抛出
            System.out.println(ex);
        } finally {
            System.out.println("这是finally块");//不关有没有异常抛出，或有没有被捕获都会执行finally
        }
        System.out.println("这是finally之后的语句");
    }
    
}
