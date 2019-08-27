import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {


    @Test
    public void when_last_in_with_push_then_first_out_with_pop() {
        MyStack stack = new MyStack();
        stack.push(new MyStack.MyNode(1));
        stack.push(new MyStack.MyNode(2));
        Assert.assertEquals(2, stack.pop().data);
        Assert.assertEquals(1, stack.pop().data);
    }
}