package top.seefly.javase.old2017.extendspackage;

/*
 * 由于不可变实例在使用起来非常方便，所以有时候在经常使用到它时，重复new相同的对象对系统的
 * 开销非常大。所以可以使用缓冲池来解决这个问题，当缓冲池中已经有这个对象的时候可以不必在new
 * */
public class FinalDemo3 {


    public static void main(String[] args) {
        Cache a = Cache.valueOf("liu");
        Cache b = Cache.valueOf("liu");
        Cache c = Cache.valueOf("zhang");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        //System.out.println(Cache.getPos());

    }


}

class Cache {
    private static int MAX_SIZE = 10;//类变量
    private static Cache[] cache = new Cache[MAX_SIZE];//类变量，缓冲池
    private static int pos;//类变量
    private final String name;//不可变数据域

    private Cache() {//无参构造
        this.name = "";
    }

    private Cache(String name) {//有参构造
        this.name = name;
    }

    public String getName() {//访问器
        return this.name;
    }

    public static int getPos() {
        return pos;
    }

    public static Cache valueOf(String name) {//得到一个与name相同的对象
        for (int i = 0; i < MAX_SIZE; i++)
            if (cache[i] != null && cache[i].getName().equals(name))
                return cache[i];
        if (pos == MAX_SIZE)
            pos = 0;
        cache[pos++] = new Cache(name);
        return cache[pos - 1];
    }

    @Override
    public boolean equals(Object cc) {//重写equals方法
        if (this == cc)
            return true;
        if (cc != null && cc.getClass() == this.getClass()) {
            Cache c = (Cache) cc;
            if (this.getName().equals(c.getName()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() * 31;
    }
}