package solution.solution54;

/*
求二叉搜索树的第k大结点
 */

// 维护一个计数器 翻转中序遍历顺序
class Solution {
    int c;
    int res;
    public int findTargetNode(TreeNode root, int cnt) {
        if (root == null) return 0;
        inorder(root,cnt);
        return res;
    }

    private void inorder(TreeNode root, int cnt) {
        if (root == null) return;
        inorder(root.right, cnt);
        c++;
        if (cnt == c) {
            res = root.val;
            return;
        };
        inorder(root.left, cnt);
    }

    // 莫里斯中序迭代遍历 （理解不了
    public void morris(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                // 没有左子树，直接访问当前节点，并转向右子树
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                // 找到当前节点左子树中的最右节点
                TreeNode next = cur.left;
                while (next.right != null && next.right != cur) {
                    next = next.right;
                }
                if (next.right == null) {
                    // 在最右节点挂载临时回溯子树到父结点的上层
                    next.right = cur;
                    cur = cur.left;
                } else {
                    // 如果最右节点的右子树指向当前节点，说明已完成左子树的访问
                    System.out.print(cur.val + " ");
                    cur = cur.right;
                    // 恢复树的结构，去除临时的连接
                    next.right = null;
                }
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}