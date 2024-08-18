package solution.solution09;

import java.util.ArrayDeque;
import java.util.Deque;

class CQueue {
    // java栈使用Deque
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    // 构造函数
    public CQueue() {
        this.stackIn = new ArrayDeque<>();
        this.stackOut = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        this.stackIn.addLast(value);
    }

    public int deleteHead() {
        if (this.stackOut.isEmpty()) {
            if (this.stackIn.isEmpty()) {
                return -1;
            }
            Deque<Integer> temp = this.stackOut;
            this.stackOut = this.stackIn;
            this.stackIn = temp;
        }
        // 队列需要与push方向相反
        return this.stackOut.removeFirst();
    }
}