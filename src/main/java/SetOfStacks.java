import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    public int capacity;
    List<Stack> stacks = new ArrayList<>();


    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && !last.isAtCapacity()) { // add to last stack
            last.push(value);
        } else { // must create new stack
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        int v =  last.pop();
        if(last.isEmpty()) {
            stacks.remove(stacks.size() -1);
        }
        return v;
    }

    class Node {

        Node above = null;
        Node below = null;
        int data;

        public Node(int data) {
            this.data = data;
        }

    }


    public class Stack {

        private int capacity;
        public Node top, bottom;
        public int size = 0;


        public Stack(int capacity) { this.capacity = capacity; }

        public boolean isAtCapacity() { return capacity == size; }

        public void join(Node above, Node below) {
            if (below != null) below.above = above;
            if (above != null) above.below = below;
        }

        public boolean push(int v) {
            if (size >= capacity) return false;
            size++;
            Node n = new Node(v);
            if (size == 1) bottom = n;
            join(n, top);
            top = n;
            return true;
        }

        public int pop() {
            Node t = top;
            top = top.below;
            size--;
            return t.data;
        }

        public boolean isEmpty() { return size == 0; }

        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) bottom.below = null;
            size--;
            return b.data;
        }

    }


}
