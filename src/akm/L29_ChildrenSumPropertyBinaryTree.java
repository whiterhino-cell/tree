package akm;

// Java program to check children sum property

/* A binary tree node has data, pointer to left child
and a pointer to right child */

class L29_ChildrenSumPropertyBinaryTree{
    TreeNode root;

    /* returns 1 if children sum property holds for the given
    node and both of its children*/
    int isSumProperty(TreeNode treeNode)
    {

		/* left_data is left child data and right_data is for right
		child data*/
        int left_data = 0, right_data = 0;

		/* If node is NULL or it's a leaf node then
		return true */
        if (treeNode == null
                || (treeNode.left == null && treeNode.right == null))
            return 1;
        else
        {

			/* If left child is not present then 0 is used
			as data of left child */
            if (treeNode.left != null)
                left_data = treeNode.left.val;

			/* If right child is not present then 0 is used
			as data of right child */
            if (treeNode.right != null)
                right_data = treeNode.right.val;

			/* if the node and both of its children satisfy the
			property return 1 else 0*/
            if ((treeNode.val == left_data + right_data)
                    && (isSumProperty(treeNode.left)!=0)
                    && isSumProperty(treeNode.right)!=0)
                return 1;
            else
                return 0;
        }
    }

    /* driver program to test the above functions */
    public static void main(String[] args)
    {
        L29_ChildrenSumPropertyBinaryTree tree = new L29_ChildrenSumPropertyBinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(2);
        if (tree.isSumProperty(tree.root) != 0)
            System.out.println("The given tree satisfies children"
                    + " sum property");
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property");
    }


}



