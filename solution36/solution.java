package solution.solution36;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

// 中序遍历存储在列表 列表转换
class Solution1 {
    public Node treeToDoublyList(Node root) {
        List<Node> nodes = new ArrayList<>();
        inorder(root,nodes);
        if (nodes.isEmpty()) {
            return null;
        }
        if (nodes.size() == 1) {
            nodes.getFirst().left = root;
            nodes.getFirst().right = root;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) {
                nodes.get(i).left = nodes.getLast();
            } else  {
                nodes.get(i).left = nodes.get(i-1);
            }
            if (i == nodes.size() - 1) {
                nodes.get(i).right = nodes.getFirst();
            } else {
                nodes.get(i).right = nodes.get(i-1);
            }
        }
        return nodes.getFirst();
    }

    public void inorder(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }
}

class Solution {
    Node head,pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
       inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        if (pre != null) {
            pre.right = root;
            root.left = pre;;
        } else {
            head = root;
        }
        pre = root;
        if (root.right != null) {
            inorder(root.right);
        }
    }
}