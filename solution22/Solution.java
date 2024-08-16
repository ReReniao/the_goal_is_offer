package solution.solution22;

import solution.ListNode.ListNode;

// 删除链表倒数第k个节点
class Solution {
    public ListNode trainingPlan2(ListNode head, int cnt) {
        ListNode fast = head, slow = head;
        for(int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
