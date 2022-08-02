package akm;

import java.util.ArrayList;
import java.util.List;

public class L30b_All_nodes_at_distance_k {

    List<TreeNode> path = null;
    //Finding all the nodes at a distance K from target
    //node.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        path = new ArrayList<>();
        findPath(root, target);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            findKDistanceFromNode(
                    path.get(i), K - i, result,
                    i == 0 ? null : path.get(i - 1));
        }
        //Returing list of all nodes at a distance K
        return result;
    }

    // Blocker is used for ancestors node if target at
    //left then we have to go in right or if target at
    // right then we have to go in left.
    public void findKDistanceFromNode(TreeNode node, int dist, List<Integer> result, TreeNode blocker) {
        if (dist < 0 || node == null || (blocker != null && node == blocker)) {
            return;
        }

        if (dist == 0) {
            result.add(node.val);
        }

        findKDistanceFromNode(node.left, dist - 1, result,
                blocker);
        findKDistanceFromNode(node.right, dist - 1, result,
                blocker);
    }
    //Finding the path of target node from root node
    public boolean findPath(TreeNode node, TreeNode target) {
        if (node == null)
            return false;

        if (node == target || findPath(node.left, target)
                || findPath(node.right, target)) {
            path.add(node);
            return true;
        }

        return false;
    }
    // Driver program to test the above functions
    public static void main(String[] args) {
        L30b_All_nodes_at_distance_k gfg = new L30b_All_nodes_at_distance_k();
        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode target = root.left.right;
        System.out.println(gfg.distanceK(root, target, 2));
    }

}
