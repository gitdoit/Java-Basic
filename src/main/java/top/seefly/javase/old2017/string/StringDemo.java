package top.seefly.javase.old2017.string;

/**
 * 本类用来演示String类的各种使用方法
 */
public class StringDemo {
    
    public static void main(String[] args) {
        String arr = new String("java demo");
        String arr1 = "java demo";
        //arr1 与arr、"java demo"的含义差不多是相同的，他们都可以用String类中的方法。
        //String arr2 = "java demo"; 这个语句不会创建新的对象，而是指向arr1中的对象
        arr1 = "java good";
        //这个语句并不会改变arr1中所指的对象，而是重新建立了一个对象并指向了它。原来的字符串将被回收
        arr.replace('j', 'J');
        //创建一个新的字符串，将原来的字符串中所有的字符j都会替换为J之后赋给它。
        arr.replace("Ja", "ja");
        //创建一个新的字符串，将原来的字符串中所有的字符串"JA"都会替换为"ja"之后赋给它。
        arr.replaceFirst("e", "AB");
        //创建一个新的字符串，将原来的字符串中第一个字符串"e"替换为"AB"之后赋给它。
        String[] arr3 = "java#is#good".split("#");
        //将字符串中指定符号作为分隔符来拆分成字符串数组存储。
        String[] arr4 = "java@is#very$good".split("[@#$]");
        //只要出现正则表达式[@#$]中任意一个字符都可以作为分隔符来拆分字符串
        
        char[] arr5 = arr1.toCharArray();
        //将字符串转换为数组
        
        boolean a = false;
        String arr6 = String.valueOf(a);
        //静态方法。将各种基本类型的数据转换成字符串。
        char b = arr1.charAt(0);
        //获取字符串中指定下标的字符
        System.out.println(arr6);
        
    }
    
}
