package top.seefly.javase.old2017.arraypackage;

/* 该类为自定义的泛型基础类
 * 有两个私有数据域
 * 两个构造方法
 * 两个访问器
 * 尖括号内的T 为待定义的类型
 *
 * */          //Pair<T extends Comparable> \<T super String>
public class Pair<T> {/*Pair<T extends Comparable> 说明T只能是Comparable的子类型，如果擦除类型。则T只能是Comparable
					如果想让T只能接受数字类型的话，就Pair<T extends Number> 这样T只能是Double Integer Short Long Float Byte
					这种方法叫做上限配置。即T的上限就是Number，泛型类型不能再比他更高级，只能是他或是他的子类
					Pair<T super String> 这种方法叫做下限配置，泛型类型T只能是String或者是他的父类
					*/
    
    private T first;
    
    private T second;
    
    public Pair() {
        first = null;
        second = null;
    }
    
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() {
        return first;
    }
    
    public T getSecond() {
        return second;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
}
