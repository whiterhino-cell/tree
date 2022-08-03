package akm;

public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
