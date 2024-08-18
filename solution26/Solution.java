package solution.solution26;

import solution.BinaryTree.TreeNode;

/*
判断二叉树B是否是A的子结构
 */

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A == null) {
            return false;
        }
        // 判断根和子树
        return match(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 只判断传入树是否是子结构
    private boolean match(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val == B.val) {
            return match(A.left, B.left) && match(A.right, B.right);
        }
        return false;
    }
}