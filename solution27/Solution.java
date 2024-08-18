package solution.solution27;

import solution.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    // 迭代
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }
}
