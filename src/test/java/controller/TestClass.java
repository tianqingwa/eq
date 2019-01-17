package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;

/**
 * @author tianqinghua
 * @date 2018/12/10 18:04
 */

public class TestClass {
    @Test
    public void testCountAndSay() {
        int n = 9;
        String res = "";
        String curStr = "1";
        int count = 0;
        for (int i = 0; i < n - 1; ++i) {
            char[] chars = curStr.toCharArray();
            char pre = chars[0];
            count = 1;
            for (int j = 1; j < chars.length; ++j) {
                if (pre == chars[j]) {
                    ++count;
                } else {
                    res += count + "" + pre;
                    pre = chars[j];
                    count = 1;
                }
            }
            if (count > 0) {
                res += count + "" + pre;
            }
            curStr = res;
            res = new String();
        }
        System.out.println(curStr);
    }
@Test
    public void testFormat(){
    DecimalFormat df=new DecimalFormat("#0.00");
    String s = df.format(16.99);
    System.out.println(s);

}
}
