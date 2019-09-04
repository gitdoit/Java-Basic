package interface_abstract;
/*该类展示了使用接口的意义
 * 感觉就像是将一个整体细分成各个部分，降低了耦合性
 * 定义一个抽象学生类，有的学生不抽烟，如果将抽烟这个行为定义到该类当中
 * 那么所有的学生都会继承这个行为，这显然是不合理的
 * 所以讲抽烟这个行为单独抽出来定义成一个接口，好的学生不必使用该接口。
 * 坏学生则会实现该接口来完善自己，这就实现了功能扩展.
 * 继承：是子类是超类中的一种
 * 接口：是平行关系，实现功能扩展。丰富类的功能
 * 
 * 基本功能定义在类中，扩展功能定义在接口中
 * */

abstract class Student{
	abstract void study();
	void sleep(){
		System.out.println("I AM SLEEP\n");
	}
}

interface Smoke{
	public abstract void smoke();
}

class GoodStudent extends Student{
	void study(){
		System.out.println("i am good student\n");
	}
}

class BadStudent extends Student implements Smoke{
	void study(){
		System.out.println("i am bad student\n");
	}
	public void smoke(){
		System.out.println("I am smoking,fuck off\n");
	}
}
public class inter_abstr {
	public static void main(String[] args){
		GoodStudent liujianxin = new GoodStudent();
		BadStudent yuxiangma = new BadStudent();
		liujianxin.sleep();
	}

}
