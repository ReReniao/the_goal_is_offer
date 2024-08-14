package solution.solution59;

import java.util.*;

class solution {
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
