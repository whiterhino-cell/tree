package akm;

//L34_Construct a Binary Tree from Preorder and Inorder Traversal
public class L34a_Construct_aBinaryTree {

    TreeNode root;
    static int preIndex = 0;

    TreeNode buildTree(char in[], char pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;

        TreeNode tTreeNode = new TreeNode(pre[preIndex++]);

        if (inStrt == inEnd)
            return tTreeNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, (char) tTreeNode.val);

		/* Using index in Inorder traversal, construct left and
		right subtress */
        tTreeNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tTreeNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tTreeNode;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of value in arr[start...end]
    The function assumes that value is present in in[] */
    int search(char arr[], int strt, int end, char value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /* This function is here just to test buildTree() */
    void printInorder(TreeNode treeNode) {
        if (treeNode == null)
            return;

        /* first recur on left child */
        printInorder(treeNode.left);

        /* then print the data of node */
        System.out.print(treeNode.val + " ");

        /* now recur on right child */
        printInorder(treeNode.right);
    }

    // driver program to test above functions
    public static void main(String args[]) {
        L34a_Construct_aBinaryTree tree = new L34a_Construct_aBinaryTree();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        TreeNode root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
