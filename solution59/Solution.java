package solution.solution59;

import java.util.*;

class solution {
    // 滑动窗口的最大值
    public int[] maxAltitude(int[] heights, int limit) {
        if (heights.length == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new ArrayDeque<>() {};
        for (int i = 0; i < limit; i++) {
            push(queue, heights[i]);
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(getMax(queue));
        for (int i = limit; i < heights.length; i++) {
            pop(queue,heights[i-limit]);
            push(queue,heights[i]);
            temp.add(getMax(queue));
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void pop(Deque<Integer> heights,int val) {
        if (!heights.isEmpty() && heights.getFirst() == val) {
            heights.removeFirst();
        }
    }
    private void push(Deque<Integer> heights,int val) {
        while (!heights.isEmpty() && heights.getLast() < val) {
            heights.removeLast();
        }
        heights.add(val);
    }
    private int getMax(Deque<Integer> heights) {
        if (!heights.isEmpty()) {
            return heights.getFirst();
        }
        return 0;
    }
}

/*
最大栈
 */

class Checkout {
    Deque<Integer> queue = new ArrayDeque<>();
    List<Integer> priority = new ArrayList<>();
    public Checkout() {
        this.queue = new ArrayDeque<>();
        this.priority = new ArrayList<>();
    }

    public int get_max() {
        if (!priority.isEmpty()) {
            return priority.getFirst();
        }
        return -1;
    }

    public void add(int value) {
        this.queue.addLast(value);
        // 每次入栈都把单调栈中比当前值小的弹出
        // 维护的是队列当前的最大值，这样可以保证队头元素弹出，保留的仍是正确的值
        while (!this.priority.isEmpty() && this.priority.getLast() < value) {
            this.priority.removeLast();
        }
        this.priority.addLast(value);
    }

    public int remove() {
        if (!this.queue.isEmpty()) {
            if (!this.priority.isEmpty() && Objects.equals(this.priority.getFirst(), this.queue.getFirst())) {
                this.priority.removeFirst();
            }
            return this.queue.removeFirst();
        }
        return -1;
    }
}
