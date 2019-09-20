package top.seefly.javase.designpattern.singleton;

/**
 * 内部类是延时加载的，也就是说只会在第一次使用时加载
 * 内部类不使用就不加载的特性，非常适合做单例模式
 * @author liujianxin
 * @date 2018-11-21 09:26
 */
public class StaticSingleton {
    private StaticSingleton(){}

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
