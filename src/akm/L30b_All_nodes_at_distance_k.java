package akm;

import java.util.ArrayList;
import java.util.List;

public class L30b_All_nodes_at_distance_k {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode>  path = new ArrayList<>();
        findPath(root, target,path);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            findKDistanceFromNode(
                    path.get(i), K - i, result,
                    i == 0 ? null : path.get(i - 1));
        }
        return result;
    }

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
    public boolean findPath(TreeNode node, TreeNode target,List<TreeNode>  path ) {
        if (node == null)
            return false;

        if (node == target || findPath(node.left, target,path)
                || findPath(node.right, target,path)) {
            path.add(node);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        L30b_All_nodes_at_distance_k distance_k = new L30b_All_nodes_at_distance_k();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode target = root.left.right;
        System.out.println(distance_k.distanceK(root, target, 2));
    }

}
