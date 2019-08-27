import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MyLinkedListTest {


    @Test
    public void when_addTwoNumbers_result_ok() {
        MyLinkedList.ListNode l1 = MyLinkedList.create(new int[] {2, 4, 3});
        MyLinkedList.ListNode l2 = MyLinkedList.create(new int[] {5, 6, 4});
        MyLinkedList.ListNode result = MyLinkedList.addTwoNumbers(l1, l2);
        Assert.assertEquals(Arrays.toString(new int[]{7, 0, 8}),
                Arrays.toString(MyLinkedList.stringToIntegerArray(MyLinkedList.printLinkedList(result))));

    }
}