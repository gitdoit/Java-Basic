package top.seefly.javase.old2017.classdemo;

/*
 * Person p = new Student();
 * 变量p在编译是的类型是Person,在运行时为Student。但某些情况下程序只能知道编译时的类型
 * 不能知道运行时类型。
 * 解决办法：我们了解该对象编译和运行时的具体信息，可以使用instanceof判断，再强转。就可以使用它的运行时方法
 *
 * 		  若不知道，则可以使用反射。
 * 获得Class对象：
 * 			1.使用Class.forName("baoming.leiming");
 * 			2.实例.getClass();
 * 第二种更好。
 *
 * 为什么使用反射，虽然反射降低了程序的性能，但是增添了对象创建的灵活性，有时候我们再编写程序的时候并不能一开始就确定我们需要创建什么样的对象。
 * 因为有时候它是在程序运行时才能确定的，这时候我们就需要一种动态的加载机制，就是反射。我们可以通过各种办法再程序运行的时候，向它传入相关数据，从而取得不同的类的实例。
 */
public class classDemo1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
