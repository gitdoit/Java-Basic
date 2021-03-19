package top.seefly.javase.old2017.extendspackage;

/*
 * 被final修饰的变量，只能一次赋值，可以在声明的同时赋值，也可在后面进行赋值，终身使用。系统不会对它进行默认初始化。
 * */
public class FinalDemo {
    
    final int a = 6;
    
    final String str;
    
    final int c;
    
    //final char ch; ch没有在任何地方完成它的初始化，会报错。
    final static double d;
    
    {
        //在普通初始化块中完成对final类型变量的初始化
        str = "hello";
        //已经对a赋值完成。无法再对其再次赋值
        //a = 5;
    }
    
    static {
        //可以在静态初始化块中对静态final变量进行第一次赋值
        d = 5;
        //ch = 'r';非静态变量无法在静态初始化块内赋值
    }
    
    public FinalDemo() {
        //可以在构造方法中对final类型变量进行初始化；
        c = 5;
    }
    
    public void test(final int a) {
        //a = 6; 错误，参数传入此方法的时候已经完成了初始化，无法再初始化
    }
    
    public static void main(String[] args) {
        
        //final修饰引用变量时，只能保证该引用变量的引用对象不会发生改变，但是无法保证该对象的内容不会改变。
        final int[] a = {1, 3, 5, 2};
        a[2] = 8;
        
        final String str = "刘建鑫" + 24;//会将"刘建鑫" "24"放入字符串池中，下次在使用此字符串时，直接从池中取
        final String str1 = "刘建鑫" + String.valueOf(24);//因为表达式中使用了String类中的静态方法
        //在编译时不会将str1当作宏变量
        System.out.println(str == "刘建鑫24");//为真，因为==后的"刘建鑫24"与宏变量代表的字符串是字符串池中的同一个
        System.out.println(str == str1);//为假，
        
        String str2 = "刘建鑫24";
        System.out.println(str == str2);//为真，在编译阶段就可以确定str2的值为字符串池中的为str缓冲过的字符串
        
        String str3 = "刘建鑫";
        String str4 = "24";
        String str5 = str3 + str4;
        System.out.println(str == str5);//为假，因为str5是由两个变量链接而成的，无法在编译阶段确定它的值
        //也就是说无法让str5指向缓冲池中的字符串
        
    }
    
}
