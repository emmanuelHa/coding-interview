public class MyStack {

    MyNode top;
    MyNode pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return (MyNode) item;
        }
        return null;
    }

    void push(Object item) {
        MyNode t = new MyNode(item);
        t.next = top;
        top = t;
    }


    static class MyNode {

        MyNode next = null;
        Object data;

        public MyNode(Object data) {
            this.data = data;
        }

    }

}
