package akm;

public class L38b_FlattenBinaryTree {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
    public void inOrder(TreeNode treeNode) {

        if (treeNode == null)
            return;

        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }

    TreeNode root;
    // Driver code
    public static void main(String[] args) {
        L38b_FlattenBinaryTree tree = new L38b_FlattenBinaryTree();

	/*   1
		/ \
       2	 5
	 / \	 \
	 3 4	 6

	 */

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);

        System.out.println("The Inorder traversal after " + "flattening binary tree ");

        tree.flatten(tree.root);
        tree.inOrder(tree.root);
    }

}
