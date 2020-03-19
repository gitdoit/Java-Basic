package top.seefly.javase.old2017.arraypackage;

public class PairTest3 {
    public static void main(String[] args) {
        Pair<String> i = new Pair<>();
        Pair<?> b = new Pair<String>();
        System.out.println(b.getClass().getName());
        //b.setFirst("first") ERROR 用?接受泛型对象时，不能设置该泛型对象。因为不知道？是什么东西，它的属性无法确定能否这样设置
        b.setFirst(null);//但是可以设置null
        i.setFirst("first");
        fun(i);
        fun1(i);
        fun2(i);


        /************************下面三个赋值与更下面的三个方法相比较****************************/
        //Pair<Object> c = null;
        //c = i; 这样无法通过编译

        Pair c = null;
        c = i;

        Pair<?> d = null;
        d = i;
    }
	
	/*public static void fun(Pair<Object> temp){ 形参的泛型必须是实参的父类或者同类，这样无法通过编译。
		System.out.println(temp.getFirst());
	}*/

    public static void fun(Pair<String> temp) {//同类可以编译通过
        System.out.println(temp.getFirst());
    }

    public static void fun1(Pair<?> temp) {//可以使用? 这样可以接受任意类型的泛型
        System.out.println(temp.getFirst());//可以访问，但是无法修改
        //temp.setFirst("dd");未确定的泛型，无法确定T是个什么东西，而数据域是由T定义的，所以不能更改
    }

    public static void fun2(Pair temp) {//可以擦除泛型。这样也可以
        System.out.println(temp.getFirst());
    }

}

