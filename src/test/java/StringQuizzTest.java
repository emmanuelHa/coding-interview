import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.junit.Assert.*;

public class StringQuizzTest {


    @Test(expected=InvalidArgumentException.class)
    public void removeDuplicatesWithNullInput() throws InvalidArgumentException {
        char[] str = null;
        StringQuizz.removeDuplicates(str);
    }

    @Test
    public void removeDuplicates() throws InvalidArgumentException {
        char[] str = new char[]{'a', 'a', 'a', 'a', 'a', 'a'};
        char[] noDupChar = new char[]{'a'};
        String noDupString = StringQuizz.removeDuplicates(str);
        Assert.assertEquals(String.valueOf(noDupChar), noDupString);
    }

    @Test
    public void removeNonContiguousDuplicates() throws InvalidArgumentException {
        char[] str = new char[]{'a', 'a', 'b', 'a', 'a', 'a'};
        char[] noDupChar = new char[]{'a', 'b'};
        String noDupString = StringQuizz.removeDuplicates(str);
        System.out.println(noDupString);
        Assert.assertEquals(String.valueOf(noDupChar), noDupString);
    }

    @Test
    public void anagram() throws InvalidArgumentException {
        Assert.assertTrue(StringQuizz.anagram("annabelle", "belleanna"));
    }
}