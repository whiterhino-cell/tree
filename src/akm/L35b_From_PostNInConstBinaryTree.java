package akm;

import java.util.HashMap;

public class L35b_From_PostNInConstBinaryTree {

    // Utility function to create a new node
    /* Helper function that allocates a new node */
    static TreeNode newNode(int data) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = data;
        treeNode.left = treeNode.right = null;
        return (treeNode);
    }

    /* Recursive function to conbinary of size n
    from Inorder traversal in[] and Postorder traversal
    post[]. Initial values of inStrt and inEnd should
    be 0 and n -1. The function doesn't do any error
    checking for cases where inorder and postorder
    do not form a tree */
    static TreeNode buildUtil(int in[], int post[], int inStrt, int inEnd) {

        // Base case
        if (inStrt > inEnd)
            return null;

	/* Pick current node from Postorder traversal
	using postIndex and decrement postIndex */
        int curr = post[index];
        TreeNode treeNode = newNode(curr);
        (index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return treeNode;

	/* Else find the index of this node in Inorder
	traversal */
        int iIndex = mp.get(curr);

	/* Using index in Inorder traversal, con
	left and right subtress */
        treeNode.right = buildUtil(in, post, iIndex + 1,
                inEnd);
        treeNode.left = buildUtil(in, post, inStrt,
                iIndex - 1);
        return treeNode;
    }

    static HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
    static int index;
//    This function mainly creates an unordered_map, then
//    calls buildTreeUtil()
    static TreeNode buildTree(int in[], int post[], int len) {

        // Store indexes of all items so that we
        // we can quickly find later
        for (int i = 0; i < len; i++)
            mp.put(in[i], i);

        index = len - 1; // Index in postorder
        return buildUtil(in, post, 0, len - 1 );
    }

    /* This function is here just to test */
    static void preOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.printf("%d ", treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    // Driver code
    public static void main(String[] args) {
        int in[] = {4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;
        TreeNode root = buildTree(in, post, n);
        System.out.print("Preorder of the constructed tree : \n");
        preOrder(root);
    }
}
