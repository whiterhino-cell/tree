package akm;

import java.util.ArrayDeque;
import java.util.Deque;

public class L38d_FlattenBinaryTree {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null)
        {
            if(cur.left != null)
            {
                TreeNode pre = cur.left;
                while(pre.right != null)
                {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
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
        L38d_FlattenBinaryTree tree = new L38d_FlattenBinaryTree();

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
