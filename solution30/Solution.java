package solution.solution30;

/*
实现一个getMin时间为O(1)的栈，即最小栈
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    List<Integer> priority = new ArrayList<>();
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.priority = new ArrayList<>();
    }

    public void push(int x) {
        this.stack.addLast(x);
        if (this.priority.isEmpty()) {
            this.priority.add(x);
        } else if (this.priority.getLast() >= x) {
            this.priority.add(x);
        }
    }

    public void pop() {
        int popped = this.stack.pollLast();
        if (this.priority.getLast() == popped) {
            this.priority.removeLast();
        }
    }

    public int top() {
        return this.stack.getLast();
    }

    public int getMin() {
        if (!this.priority.isEmpty()) {
            return this.priority.getLast();
        }
        return -1;
    }
}
