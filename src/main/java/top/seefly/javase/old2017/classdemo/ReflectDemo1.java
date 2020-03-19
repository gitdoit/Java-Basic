package top.seefly.javase.old2017.classdemo;
/*
 * 通过反射初始化类，并得到一个类的实例。
 * 通过反射来调用一个类的方法。
 * 通过反射获取类的内部信息。
 * 类内部的各种属性、构造方法、方法、类型、返回值、参数。。。。都可当作对象处理。
 */

import java.lang.reflect.Method;

public class ReflectDemo1 {

    public static void main(String[] args) throws ReflectiveOperationException {
        //forName会将该类加载入内存并执行初始化，得到一个类对象
        Class c = Class.forName("classdemo.ReflectTest");
        //通过类对象获取一个实例
        Object o = c.newInstance();
        //getMethods方法获取该类内部的所有方法
        Method[] methods = c.getMethods();
        for (Method e : methods) {
            if (e.getName().equals("m")) {//若方法数组中的方法名为m
                e.invoke(o);//对o对象调用m方法。
            }
            if (e.getName().equals("m1")) {
                for (Class m : e.getParameterTypes())//获取该方法的所有参数类型，以Class数组形式返回
                    System.out.println(m.getName());
            }

        }
    }

}

class ReflectTest {
    static {
        System.out.println("我被初始化了！");
    }

    int a;

    public ReflectTest() {
        System.out.println("我被实例化了！");
    }

    public void m1(int i) {
        System.out.println(i);
    }

    public void m() {
        System.out.println("m执行");
    }
}
