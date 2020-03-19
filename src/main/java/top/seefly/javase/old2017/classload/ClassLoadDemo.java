package top.seefly.javase.old2017.classload;
/*
 *
 * 类的加载是指，将该类的class文件读入内存，并为之创建一个class对象。
 * 当程序使用任何类时，都会为之创建java.lang.class对象。
 * 加载分为三步骤：加载、连接、初始化
 *
 * 1.加载，加载由类的加载器完成，加载器由JVM提供。我们还可以通过继承ClassLoader类来实现自己的加载器
 * 2.链接，验证类的内部结构，为静态属性分配内存，设置默认初始值(不是初始化)
 * 3.初始化，主要就是对静态属性初始化。静态初始化(包括静态初始化块)按顺序执行。
 *
 * 什么时候会加载类？
 * 1.任何方式创建实例的时候
 * 2.调用类的静态方法的时候
 * 3.访问类或接口的静态属性，或为类的静态属性赋值的时候
 * 3.使用反射创建类的class对象的时候
 * 4.初始化某个子类的时候，该子类的所有爹都会被初始化，辈分越大越先初始化
 * 注意：对于final static属性，如果在其值能够在编译时期就能确定下来
 * 那么它就是一个宏变量，访问他不会造成类的初始化。
 */


class Tester {
    static {
        System.out.println("Tester 类的静态初始化块");
    }

}

public class ClassLoadDemo {
    //任何地方调用AA都不会造成该类 的初始化。它能在编译时就确定下来，为宏变量
    public static final int AA = 5;
    //TIME不能在编译时其确定下来，所以调用它的时候会造成类的初始化
    public static final String Time = System.currentTimeMillis() + "";
    public static int a = 5;

    static {
        a = 4;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader c1 = ClassLoader.getSystemClassLoader();
        //此语句仅仅是加载类，并不会执行初始化。则不会执行初始化块
        c1.loadClass("loadclass.Tester");
        System.out.println("系统加载Tester类！step 1");
        //下面会执行类的初始化，会执行到类的静态初始化块
        Class.forName("loadclass.Tester");

    }

}
