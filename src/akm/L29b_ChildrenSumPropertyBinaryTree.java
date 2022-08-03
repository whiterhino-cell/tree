package akm;

class L29b_ChildrenSumPropertyBinaryTree {
    TreeNode root;

    void isSumProperty(TreeNode root){
        if (root == null) return;
        int child = 0;
        if (root . left!=null) {
            child += root . left .val;
        }
        if (root . right!=null) {
            child += root . right .val;
        }

        if (child < root .val) {
            if (root . left!=null) root . left .val = root .val;
            else if (root . right!=null) root . right .val = root .val;
        }

        isSumProperty(root . left);
        isSumProperty(root . right);

        int tot = 0;
        if (root . left!=null) tot += root . left .val;
        if (root . right!=null) tot += root . right .val;
        if (root . left!=null || root . right!=null) root .val = tot;
    }

    /* driver program to test the above functions */
    public static void main(String[] args)
    {
        L29b_ChildrenSumPropertyBinaryTree tree = new L29b_ChildrenSumPropertyBinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(2);
      tree.isSumProperty(tree.root) ;
    }


}



