package test.java.lang;

import org.junit.Test;

import java.util.stream.IntStream;

public class CharSequenceSepc {

    @Test
    public void codePoints() {
        String str = "hello world";
        IntStream intStream = str.codePoints();
        System.out.println(intStream);
    }
}
