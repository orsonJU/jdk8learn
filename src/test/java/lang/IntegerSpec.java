package test.java.lang;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntegerSpec {

    @Test
    public void test_getchars() {
        int count = Integer.bitCount(7);
        System.out.println(count);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
