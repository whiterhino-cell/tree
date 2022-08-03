package akm;

public class L37a_MorrisTraversal {

    TreeNode root;

    void morrisTraversalPreorder() {
        morrisTraversalPreorder(root);
    }

    void morrisTraversalPreorder(TreeNode treeNode) {
        while (treeNode != null) {

            if (treeNode.left == null) {
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            } else {

                TreeNode current = treeNode.left;
                while (current.right != null && current.right != treeNode) {
                    current = current.right;
                }

                if (current.right == treeNode) {
                    current.right = null;
                    treeNode = treeNode.right;
                }

                else {
                    System.out.print(treeNode.val + " ");
                    current.right = treeNode;
                    treeNode = treeNode.left;
                }
            }
        }
    }

    void preorder() {
        preorder(root);
    }

    void preorder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            preorder(treeNode.left);
            preorder(treeNode.right);
        }
    }

    // Driver programs to test above functions
    public static void main(String args[]) {
        L37a_MorrisTraversal tree = new L37a_MorrisTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.left.left.left = new TreeNode(8);
        tree.root.left.left.right = new TreeNode(9);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(11);
        tree.morrisTraversalPreorder();
        System.out.println("");
        tree.preorder();

    }

}
