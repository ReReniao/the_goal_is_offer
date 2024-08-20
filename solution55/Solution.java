package solution.solution55;

import solution.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
树的深度 树的深度等于左右子树较深的加1
 */


class Solution {
    // DFS
    public int calculateDepth(TreeNode root) {
        if (root == null) return 0;
        return 1+max(calculateDepth(root.left), calculateDepth(root.right));
    }

    private int max(int a,int b) {
        return a>b?a:b;
    }

    // BFS
    public int calculateDepth1(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }
        return level;
    }
}

/*
判断是否平衡二叉树
 */

class Solution1 {
    public boolean isBalanced(TreeNode root) {
       return check(root) != -1;
    }

    // 约定不平衡返回-1 否则返回深度
    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }
        if (abs(left,right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    private int abs(int a,int b) {
        if (a > b) {
            return a - b;
        }
        return b-a;
    }
}