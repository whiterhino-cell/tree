package akm;

public class L30a_All_nodes_at_distance_k {

    void printKDistanceNodeDown(TreeNode treeNode, int k) {
        // Base Case
        if (treeNode == null || k < 0)
            return;

        if (k == 0) {
            System.out.print(treeNode.val);
            System.out.println("");
            return;
        }

        printKDistanceNodeDown(treeNode.left, k - 1);
        printKDistanceNodeDown(treeNode.right, k - 1);
    }

    int distanceK(TreeNode treeNode, TreeNode target, int k) {
        if (treeNode == null)
            return -1;

        if (treeNode == target) {
            printKDistanceNodeDown(treeNode, k);
            return 0;
        }

        int dl = distanceK(treeNode.left, target, k);

        if (dl != -1) {

            if (dl + 1 == k) {
                System.out.print(treeNode.val);
                System.out.println("");
            }else
                printKDistanceNodeDown(treeNode.right, k - dl - 2);
            return 1 + dl;
        }

        int dr = distanceK(treeNode.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.print(treeNode.val);
                System.out.println("");
            }
            else
                printKDistanceNodeDown(treeNode.left, k - dr - 2);
            return 1 + dr;
        }

        return -1;
    }
    TreeNode root;
    public static void main(String args[]) {
        L30a_All_nodes_at_distance_k tree = new L30a_All_nodes_at_distance_k();

        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        TreeNode target = tree.root.left.right;
        tree.distanceK(tree.root, target, 2);
    }
}
