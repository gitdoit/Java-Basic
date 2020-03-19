package top.seefly.javase.old2017.extendspackage;

/*
 * final修饰类的时候(String类)，此类无法被继承，且其数据域无法被修改。
 * 所以在定义此类时候，需要做到一下几点
 * 使用private final修饰该类的数据域，即类一经实例化之后就不可改变其数据域。
 * 提供有参构造方法对数据域进行初始化
 * 不要提供修改器
 * 必要的时候需要重写toString(),equals(),hashCode()
 *
 * */
public class FinalDemo2 {
    private final String detail;
    private final String PostCode;

    public FinalDemo2() {
        detail = "";
        PostCode = "";
    }

    public FinalDemo2(String detail, String PostCode) {
        this.detail = detail;
        this.PostCode = PostCode;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return PostCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && getClass() == obj.getClass()) {
            FinalDemo2 Fd = (FinalDemo2) obj;
            if (this.getDetail().equals(Fd.getDetail()) &&
                    this.getPostCode().equals(Fd.getPostCode()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return detail.hashCode() + PostCode.hashCode();
    }

    @Override
    public String toString() {
        return String.format("The detail is %s and PostCode is %s", detail, PostCode);
    }

    public static void main(String[] args) {

    }

}
