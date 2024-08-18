package solution.solution28;

import solution.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
判断二叉树是否对称
 */
class Solution {
    // DFS
    public boolean checkSymmetricTree(TreeNode root) {
        // 左右子树相等的数就是轴对称的
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
    }
}
