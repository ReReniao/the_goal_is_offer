package solution.solution18;

import solution.ListNode.ListNode;

class Solution {
    // 迭代
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }

    // 递归
    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode1(head.next,val);
        return head;
    }
}

