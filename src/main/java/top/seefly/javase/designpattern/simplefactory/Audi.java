package top.seefly.javase.designpattern.simplefactory;

/**
 * @author liujianxin
 * @date 2019/9/15 20:44
 */
public class Audi implements Car {
    @Override
    public void description() {
        System.out.println("This is Audi!");
    }
}
