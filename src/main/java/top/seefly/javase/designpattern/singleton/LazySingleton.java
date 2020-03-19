package top.seefly.javase.designpattern.singleton;

/**
 * 单例模式的职责就是确保一个类只有一个实例
 * <p>
 * <p>
 * 懒加载的单例模式
 * 在getInstance上加锁防止并发环境下创建多个实例，并进行懒加载
 * 优点是可以控制单例的创建时间，缺点是在高并发环境下性能较差。
 *
 * @author liujianxin
 * @date 2018-11-20 19:56
 */
public class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    /**
     * 这种方式也可能有问题
     * 就是这个实例在还没有被完全创建成功的时候引用就被使用了，这时候会产生异常情况
     * 但是可以使用 volatile 关键字保证不会指令重排序
     */
    public static LazySingleton getInstance2() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    return singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
