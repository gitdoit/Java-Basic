package top.seefly.javase.designpattern.simplefactory;

/**
 * @author liujianxin
 * @date 2019/9/15 20:43
 */
public class BWM implements Car {
    
    @Override
    public void description() {
        System.out.println("This is a BWM!");
    }
}
