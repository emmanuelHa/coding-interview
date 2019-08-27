import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitManipulationTest {


    @Test
    public void updateBits() {
        //int n = 10000000000;
        //int m = 10101;
        int n = 1024;
        int m = 21;
        int i = 2;
        int j = 6;

        int result = BitManipulation.updateBits(n, m, i, j);
        Assert.assertEquals(n + 4 + 16 + 64, result);
    }

    @Test
    public void printBinary() {
        String stringRepresentation = BitManipulation.printBinary("4.75");
        Assert.assertEquals("100.11", stringRepresentation);
    }

    @Test
    public void bitSwapRequired() {
        // 00101010 42
        // 00001111 15
        // 00100101 37
        int swapRequired = BitManipulation.bitSwapRequired(42, 15);
        Assert.assertEquals(3, swapRequired);
    }
}