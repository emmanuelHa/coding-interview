public class MyQueue {

    MyStack.MyNode first, last, front, back;

    void enqueue(Object item) {

        // ?
        if (first == null) {
            back = new MyStack.MyNode(item);
            first = back;
        } else {
            back.next = new MyStack.MyNode(item);
            back = back.next;
        }
    }

    MyStack.MyNode dequeue(MyStack.MyNode n) {

        if (front != null) {
            Object item = front.data;
            front = front.next;
            return (MyStack.MyNode) item;
        }
        return null;
    }
}
