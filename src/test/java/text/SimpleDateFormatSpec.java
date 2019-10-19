package test.java.text;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatSpec {

    @Test
    public void test_compile() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String format = sdf.format(new Date());
    }
}
