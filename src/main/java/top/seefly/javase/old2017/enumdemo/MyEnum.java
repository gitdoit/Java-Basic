package top.seefly.javase.old2017.enumdemo;
/*自定义的枚举类型，其中包含数据域，且有访问器
 * 还演示了Enum.valueOf()方法的使用
 * 以及枚举对象可以用==比较
 *
 * */

import java.util.*;

public class MyEnum {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size(SAMLL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);//Enum.valuesof(枚举类型，枚举元素名)；得到该枚举类型的中名为“枚举元素名”的枚举对象
        //该静态方法会抛出一个运行时异常在没有对应的元素名时
        System.out.println("size:" + size);
        System.out.println("size=" + size.getSize());//访问器访问枚举对象的数据域
        if (size == Size.SMALL) {
            System.out.println("你穿的是S号");
        }
        
    }
    
    
}

enum Size {//自定义枚举类型包括方法。
    //下面这里就相当于new 一个枚举对象了
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("LX");
    
    private Size(String size) {
        this.size = size;
    }
    
    public String getSize() {
        return size;
    }
    
    private String size;
}
