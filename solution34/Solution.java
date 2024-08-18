package solution.solution34;

import solution.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    // BFS 层序遍历
    // 创建虚拟结点 包含路径和路径和
    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        Deque<VNode> queue = new LinkedList<>();
        List<Integer> initPath = new ArrayList<>();
        initPath.addLast(root.val);
        queue.offerLast(new VNode(root,root.val,initPath));
        while(!queue.isEmpty()) {
            VNode node = queue.pollFirst();
            if (node.sum == target && node.node.left == null && node.node.right == null) {
                res.addLast(new ArrayList<>(node.path));
            }
            if (node.node.left != null) {
                List<Integer> temp = new ArrayList<>(node.path);
                temp.addLast(node.node.left.val);
                queue.offerLast(new VNode(node.node.left,node.sum+node.node.left.val,temp));
            }
            if (node.node.right != null) {
                List<Integer> temp = new ArrayList<>(node.path);
                temp.addLast(node.node.right.val);
                queue.offerLast(new VNode(node.node.right,node.sum+node.node.right.val,temp));
            }
        }
        return res;
    }

    // DFS
    private void DFS(TreeNode root, List<Integer> path, int target) {
        if (root == null ||root.val > target) {
            return;
        }
        path.add(root.val);

        if (target == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        DFS(root.left, path, target-root.val);
        DFS(root.right, path, target-root.val);
        path.remove(path.size()-1);
    }
}

class VNode {
    TreeNode node;
    int sum;
    List<Integer> path;
    VNode(TreeNode node, int sum, List<Integer> path) {
        this.node = node;
        this.sum = sum;
        this.path = path;
    }
}
