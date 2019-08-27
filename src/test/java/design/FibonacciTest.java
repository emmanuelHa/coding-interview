package design;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void fibo() {
        int fibo = new Fibonacci().fibo(7);
        Assert.assertEquals(13, fibo);
    }

    @Test
    public void fiboRec() {
        int fibo = new Fibonacci().fiboRec(7);
        Assert.assertEquals(13, fibo);
    }
}