import java.util.Arrays;

public class MyLinkedList {


    public static void main(String[] args) {
        ListNode l1 = create(new int[]{2, 4, 3});
        ListNode l2 = create(new int[]{5, 6, 4});
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode create(int[] nums) {
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int num : nums) {
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }


    private static ListNode next(ListNode listNode) {
        return listNode.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        //input = input.substring(1, input.length() - 1);
        /*if (input.length() == 0) {
            return new int[0];
        }*/

        char[] chars = input.toCharArray();
        int[] result = new int[chars.length];

        int i = 0;
        for (char c: chars) {
            result[i++] = Integer.parseInt(String.valueOf(c));
        }
        System.out.println(result);
        return result;
        /*
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;*/
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static void prettyPrintLinkedList(ListNode node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("Empty MyLinkedList");
        }
    }
    public static String printLinkedList(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null && node.next != null) {
            stringBuilder.append(node.val);
            node = node.next;
        }

        if (node != null) {
            stringBuilder.append(node.val);
        } else {
            System.out.println("Empty MyLinkedList");
        }
        return stringBuilder.toString();
    }


    public int[] twoSum(int[] nums, int target) {
        int sum, j = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = nums[i - 1] + nums[i];
            if (sum == target) {
                j = i;
                break;
            }
        }
        int[] result = {j, j - 1};
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }


        public class Node {

            Node next = null;
            int data;

            public Node(int d) {
                data = d;
            }

            void appendToTail(int d) {
                Node end = new Node(d);
                Node n = this;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = end;
            }

            Node deleteNode(Node head, int d) {
                Node n = head;
                if (n.data == d) {
                    return head.next; /* moved head */
                }

                while (n.next != null) {
                    if (n.next.data == d) {
                        n.next = n.next.next;
                        return head; /* head didn’t change */
                    }
                    n = n.next;
                }
                return head;
            }
        }
    }
