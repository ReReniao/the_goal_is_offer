package solution.solution06;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] reverseBookList(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            nodes.add(cur.val);
        }
        int[] res = new int[nodes.size()];
        reverser(nodes,res);
        return res;
    }



    private void reverser(List<Integer> nodes,int[] res) {
        for (int i = 0; i < res.length; i++) {
            res[i] = nodes.get(nodes.size()-i-1);
        }
    }

    private void DFS(ListNode head, List<Integer> nodes) {
        if (head == null) {
            return;
        }
        DFS(head.next, nodes);
        nodes.add(head.val);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}