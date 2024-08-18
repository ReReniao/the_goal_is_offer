package solution.solution32;

import solution.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
层序遍历
 */

// 一个数组存储遍历结果
class Solution1 {
    public int[] decorateRecord(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            list.addLast(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

// 分层存储遍历结果
class Solution2 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.removeFirst();
                level.addLast(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}

// s型存储遍历结果
class Solution {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        boolean fromLeft = true;
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.removeFirst();
                if (fromLeft) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            fromLeft = !fromLeft;
            res.add(level);
        }
        return res;
    }
}