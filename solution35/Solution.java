package solution.solution35;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 复杂链表的复制
class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node newHead = new Node(cur.val);
        Node newCur = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(cur,newCur);
        // 线性复制
        while (cur.next != null) {
            newCur.next = new Node(cur.next.val);
            map.put(cur.next, newCur.next);
            cur = cur.next;
            newCur = newCur.next;
        }
        cur = head;
        newCur = newHead;
        while (cur != null) {
            newCur.random = map.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}