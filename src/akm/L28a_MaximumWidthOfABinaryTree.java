package akm;

class L28a_MaximumWidthOfABinaryTree {

    int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        int width;
        int h = height(root);
        int i;

        for (i = 1; i <= h; i++) {
            width = getWidth(root, i);
            if (width > maxWidth)
                maxWidth = width;
        }

        return maxWidth;
    }

    int getWidth(TreeNode node, int level) {
        if (node == null)
            return 0;

        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
        return 0;
    }

    int height(TreeNode node) {
        if (node == null)
            return 0;
        else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);

            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }

    public static void main(String args[]) {
        L28a_MaximumWidthOfABinaryTree tree = new L28a_MaximumWidthOfABinaryTree();

		/*
		Constructed binary tree is:
			1
			/ \
		2 3
		/ \ \
		4 5	 8
		     / \
			6   7
		*/
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        // Function call
        System.out.println("Maximum width is " + tree.widthOfBinaryTree(root));
    }
}



