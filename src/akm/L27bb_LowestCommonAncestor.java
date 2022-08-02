package akm;

//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree

/* Class containing left and right child of current
node and key value*/

public class L27bb_LowestCommonAncestor {


    TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;

        if (node == p || node == q)
            return node;

        TreeNode left_lca = findLCA(node.left, p, q);
        TreeNode right_lca = findLCA(node.right, p, q);

        if (left_lca!=null && right_lca!=null)
            return node;

        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String args[])
    {
        L27bb_LowestCommonAncestor tree = new L27bb_LowestCommonAncestor();
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(root,root.left.left,root.left.right).val);
        System.out.println("LCA(4, 6): " + tree.findLCA(root,root.left.left,root.right.left).val);
        System.out.println("LCA(3, 4): " + tree.findLCA(root,root.right ,root.left.left).val);
        System.out.println("LCA(2, 4): " + tree.findLCA(root,root.left,root.left.left).val);

    }


}

