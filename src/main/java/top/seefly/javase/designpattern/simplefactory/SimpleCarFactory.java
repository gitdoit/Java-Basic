package top.seefly.javase.designpattern.simplefactory;

/**
 * 简单工厂模式优点
 * 1、屏蔽了对象创建的细节
 * 2、隐藏细节类型
 * 3、创建和使用分离，更加便于维护，符合依赖倒置原则
 * <p>
 * 缺点
 * 不符合开闭原则，如果有新增加的类那么会变更代码
 *
 * @author liujianxin
 * @date 2019/9/15 20:45
 */
public class SimpleCarFactory {

    public static void main(String[] args) {
        Car bwm = SimpleCarFactory.create("bwm");
        bwm.description();
    }


    public static Car create(String type) {
        if ("bwm".equals(type)) {
            return new BWM();
        } else if ("audi".equals(type)) {
            return new Audi();
        } else {
            throw new IllegalArgumentException("No such car!");
        }
    }
}
