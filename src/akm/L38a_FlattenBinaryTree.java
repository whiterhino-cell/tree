package akm;

public class L38a_FlattenBinaryTree {

    TreeNode root;

    public void flatten(TreeNode root) {

        if (root == null)
            return;

        if (root.left == null &&
                root.right == null)
            return;

        if (root.left != null) {

            flatten(root.left);

            TreeNode tempTreeNode = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode curr = root.right;
            while (curr.right != null) {
                curr = curr.right;
            }

            curr.right = tempTreeNode;
        }
        flatten(root.right);

    }

    public void inOrder(TreeNode treeNode) {

        if (treeNode == null)
            return;

        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }

    // Driver code
    public static void main(String[] args) {
        L38a_FlattenBinaryTree tree = new L38a_FlattenBinaryTree();

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
