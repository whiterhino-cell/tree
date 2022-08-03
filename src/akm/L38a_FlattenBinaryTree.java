package akm;

public class L38a_FlattenBinaryTree {

    TreeNode root;

//    Function to convert binary tree into
//    linked list by altering the right node
//    and making left node NULL
    public void flatten(TreeNode treeNode) {

        // Base case - return if root is NULL
        if (treeNode == null)
            return;

        // Or if it is a leaf node
        if (treeNode.left == null &&
                treeNode.right == null)
            return;

        // If root.left children exists then we have
        // to make it node.right (where node is root)
        if (treeNode.left != null) {

            // Move left recursively
            flatten(treeNode.left);

            // Store the node.right in
            // Node named tempNode
            TreeNode tempTreeNode = treeNode.right;
            treeNode.right = treeNode.left;
            treeNode.left = null;

            // Find the position to insert
            // the stored value
            TreeNode curr = treeNode.right;
            while (curr.right != null) {
                curr = curr.right;
            }

            // Insert the stored value
            curr.right = tempTreeNode;
        }

        // Now call the same function
        // for node.right
        flatten(treeNode.right);

    }

    // Function for Inorder traversal
    public void inOrder(TreeNode treeNode) {

        // Base Condition
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
