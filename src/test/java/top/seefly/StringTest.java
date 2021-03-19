package top.seefly;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author liujianxin
 * @date 2018-10-26 09:40
 */
public class StringTest {
    
    public static void main(String[] args) {
        
        BigDecimal bigDecimal = BigDecimal.valueOf(122.32343);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(123.34132);
        
        BigDecimal add = bigDecimal.add(bigDecimal1);
        BigDecimal bigDecimal2 = add.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal2.toString());
        
    }
    
    public static void toLuigi(String original) {
        try {
            Field stringValue = String.class.getDeclaredField("value");
            stringValue.setAccessible(true);
            stringValue.set(original, "Luigi".toCharArray());
        } catch (Exception ex) {
            // Ignore exceptions
        }
    }
    
    
}
