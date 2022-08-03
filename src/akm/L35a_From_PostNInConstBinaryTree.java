package akm;

public class L35a_From_PostNInConstBinaryTree {

    /* Recursive function to construct binary of size n
    from Inorder traversal in[] and Postrder traversal
    post[]. Initial values of inStrt and inEnd should
    be 0 and n -1. The function doesn't do any error
    checking for cases where inorder and postorder
    do not form a tree */
    TreeNode buildUtil(int in[], int post[], int inStrt, int inEnd, int postStrt, int postEnd) {
        // Base case
        if (inStrt > inEnd)
            return null;

		/* Pick current node from Postrder traversal using
		postIndex and decrement postIndex */
        TreeNode treeNode = new TreeNode(post[postEnd]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return treeNode;
        int iIndex = search(in, inStrt, inEnd, treeNode.val);

		/* Using index in Inorder traversal, construct left
		and right subtress */
        treeNode.left = buildUtil(in, post, inStrt, iIndex - 1, postStrt, postStrt - inStrt + iIndex - 1);
        treeNode.right = buildUtil(in, post, iIndex + 1, inEnd, postEnd - inEnd + iIndex, postEnd - 1);

        return treeNode;
    }

    /* Function to find index of value in arr[start...end]
    The function assumes that value is postsent in in[]
    */
    int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    /* This function is here just to test */
    void preOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    // Driver Code
    public static void main(String[] args) {
        L35a_From_PostNInConstBinaryTree tree = new L35a_From_PostNInConstBinaryTree();
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        TreeNode root = tree.buildUtil(in, post, 0, n - 1, 0, n - 1);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}
