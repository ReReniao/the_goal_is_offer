package solution.solution24;

import solution.ListNode.ListNode;

// 翻转链表
// 迭代
class Solution {
    // 迭代
    public ListNode trainningPlan3(ListNode head) {
      ListNode pre = null,next = null;
      ListNode cur = head;
      // cur.next 可以为空
      while(cur != null) {
          next = cur.next;
          cur.next = pre;

          pre = cur;
          cur = next;
      }
      return cur;
    }

    // 递归
    public ListNode trainningPlan31(ListNode head) {
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }
}
