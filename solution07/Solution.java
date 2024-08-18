package solution.solution07;

import solution.BinaryTree.TreeNode;

class Solution {
    int[] preorder;
    int[] inorder;
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode build(int preStart,int preEnd,int inStart,int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int index = findIndex(inorder,inStart,inEnd,root.val);
        int leftSize = index - inStart;
        root.left = build(preStart+1,preStart+leftSize,inStart,index-1);
        root.right = build(preStart+leftSize+1,preEnd,index+1,inEnd);
        return root;
    }

    private int findIndex(int[] nums,int start,int end, int val) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
