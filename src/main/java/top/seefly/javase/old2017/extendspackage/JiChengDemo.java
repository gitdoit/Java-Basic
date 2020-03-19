package top.seefly.javase.old2017.extendspackage;

/**
 * 在使用继承时，数据域也会出现覆盖现象。但是在实例化时也会为其分配存储空间
 * 类的数据域不具有多态性。
 * 多态时，引用变量只能调用其声明类型所拥有的方法，但如果实际类型也拥有这个方法，那么此时会出现多态性，即调用实际类型中的方法，而同时
 * 因为数据域没有多态性，所以实际调用的那个方法会使用同类中的数据域。
 * <p>
 * <p>
 * 用来学习继承
 * 子类中有俩方法，一个公共的shou方法：返回一段字符串，一个私有的show方法：返回一段字符串
 * 父类中有四个方法，公共的shou方法：返回一段字符串，私有的show:返回一段字符串，公共的print：打印show（）
 * 公共的printDame:打印shou()
 * <p>
 * 父类  实例 = new 子类();
 * 如果要使用多态那么必须在父类中定义一个方法，并在子类中覆盖/重写.即子类和父类中都有 ‘方法’这个方法
 * 这样就可以用父类变量引用子类中的覆盖方法 ：实例.方法 （方法在子类中被重写了才能引用到子类中的这个方法）
 * 如果父类中没有这个方法而子类中有，那么需要进行显示转换才能使用子类中的方法 注：转换不会创建一个新的对象
 * (子类)(实例).方法1
 * <p>
 * 表达式(实例1 instanceof 实例2) 得到的是一个boolean值，类型相同为真
 * 表达式(实例1 == 实例2) 的意思是判断两个变量是否指向同一个实例，即地址是否相同
 * 表达式：实例.equals(实例1) 的意思是判断两个变量是否指向同一个实例，即地址是否相同
 * 表达式：字符串.equals(字符串1) 判断两个字符串变量的地址是否相同
 * 表达式：字符串 == 字符串1 判断两个字符串的内容是否一样，不考虑地址
 */
public class JiChengDemo extends B {
    public static void main(String[] args) {
        B demo = new JiChengDemo();
        //多态，父类型的变量可以引用子类型的对象，也可以将子类型变量赋给父类型，前提是子类型变量要有指向。
        demo.shou();
        //动态绑定，虽然声明的是父类B类型，但是实际类型为JiChengDemo，所以使用的shou为本类中的
        //但如果父类中没有shou()这个方法那么这个语句就是错误的。需要强转之后才行
        demo.printDemo();
        //demo的实际类型是子类型，但子类中没有printDemo方法，所以使用的是父类中的这个方法
        //而printDemo方法又使用了shou方法，子类中有这个方法，所以shou使用的是子类中的
        demo.print();
        //print为父类中的方法，子类中没有。而print方法中使用了show方法，这个方法子类中有
        //但是它为私有的，只能在本类中使用。而print方法却在父类之中，所以只能使用父类中的show方法
		/*JiChengDemo a = new JiChengDemo();
		if(a instanceof JiChengDemo)
			System.out.println("是的");
		else
			System.out.println("不是的");*/
        B element = new B();
        Object element1 = new B();
        System.out.println(element.equals(element1));
    }

    //无参构造
    JiChengDemo() {
        //super引用父类有参构造
        //super(2);
    }

    //有参构造
    JiChengDemo(int a) {
        System.out.println("这是A类");
    }

    private String show() {
        return "子类私有方法";
    }

    @Override
    public String shou() {
        return "JiCheng";
    }

}

class B {
    //实例化时，子类在执行构造函数前会将父类中的无参构造函数先执行。所以这里首先打印“B类无参”
    B() {
        System.out.println("这是B类无参");
    }

    B(int a) {
        System.out.println("这是B类有参");
    }


    public String shou() {
        return "B";
    }

    public void printDemo() {
        System.out.println(shou());
    }

    private String show() {
        return "B";
    }

    public void print() {
        System.out.println(show());
    }
	/*public boolean equals(Object obj){
		return false;
	}*/
}

/*class C{
	C(){
		this("这是C类的无参函数内的调用");
		System.out.println("这是C类");
	}
	C(String s){
		System.out.println(s);
	}
	public double shou(){
		return 2.0;
	}
}*/