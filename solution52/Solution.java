package solution.solution52;

import solution.ListNode.ListNode;

// 寻找链表的第一个公共结点
class Solution {
    // 长的链表先走长度差 然后一起走 使用 == 判断对象是否相等
    ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode currA = headA,currB = headB;
        int lengthA = 0,lengthB = 0;
        while (currA != null || currB != null) {
            if (currA != null) {
                lengthA++;
                currA = currA.next;
            }
            if (currB != null) {
                lengthB++;
                currB = currB.next;
            }
        }
        currA = headA;
        currB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < abs(lengthA-lengthB); i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < abs(lengthA-lengthB); i++) {
                currB = currB.next;
            }
        }
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
    private int abs(int a) {
        if (a > 0) {
            return a;
        } else {
            return -a;
        }
    }

    // 独立部分长度 为A B 公共部分长度 为shared
    // 根据加法交换律 链表长度相加 A+B+2shared = B+A+shared
    // 表示两个链表有公共部分，将链表连接成一个循环后肯定会有一个交点
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA,currB = headB;
        while (currA != null || currB != null) {
            // 循环终点
            if (currA == currB) {
                return currA;
            }
            if (currA == null) {
                currA = headB;
            }else {
                currA = currA.next;
            }
            if (currB == null) {
                currB = headA;
            } else {
                currB = currB.next;
            }
        }
        return null;
    }
}
