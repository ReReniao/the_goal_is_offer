package solution.solution33;

import solution.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
验证序列是否是平衡二叉树的后序遍历
 */
class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int cur = postorder[i];
            if (root < cur) {
                return false;
            }
            // 遍历到左子树
            // 切换到左子树根结点为遍历根结点
            while (!stack.isEmpty() && stack.getLast() > cur) {
                root = stack.removeLast();
            }
            // 遍历右子树
            stack.addLast(cur);
        }
        return true;
    }
}
