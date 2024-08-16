package solution.solution25;

import solution.ListNode.ListNode;

// 合并两个递增链表
class Solution {
    // 归并思想
    public ListNode trainningPlan1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummy.next;
    }

    // 递归
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = trainningPlan(l1.next, l2);
            return l1;
        }else {
            l2.next = trainningPlan(l1, l2.next);
            return l2;
        }
    }


}