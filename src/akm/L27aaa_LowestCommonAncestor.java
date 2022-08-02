package akm;

import java.util.ArrayList;
import java.util.List;

public class L27aaa_LowestCommonAncestor {

    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1= new ArrayList<>();
        List<TreeNode> path2= new ArrayList<>();
        if (!findPath(root, p, path1) || !findPath(root, q, path2)) {
            return null;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    private boolean findPath(TreeNode root, TreeNode n, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    // Driver code
    public static void main(String[] args)
    {
        L27aaa_LowestCommonAncestor tree = new L27aaa_LowestCommonAncestor();
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
// This code is contributed by Sreenivasulu Rayanki.
//LCA(4, 5): 2
//LCA(4, 6): 1
//LCA(3, 4): 1
//LCA(2, 4): 2