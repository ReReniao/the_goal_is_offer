package solution.solution41;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            if  (minHeap.isEmpty() || num > minHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
                int top = maxHeap.poll();
                minHeap.offer(top);
            }
        } else {
            if (num < maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
                int top = minHeap.poll();
                maxHeap.offer(top);
            }
        }
    }

    public double findMedian() {
        if (this.minHeap.size() == this.maxHeap.size()) {
            return (this.minHeap.peek()+this.maxHeap.peek())/2.0;
        } else {
            return this.maxHeap.peek();
        }
    }
}
