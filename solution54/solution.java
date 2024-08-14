package solution.solution54;

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

    private void morris(TreeNode root) {

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