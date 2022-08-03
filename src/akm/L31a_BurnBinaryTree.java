package akm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L31a_BurnBinaryTree {

    public int solve(TreeNode root, int num) {
        if (root==null)
            return -1;
        Map<Integer, Set<Integer>> levelOrderMap=new HashMap<>();
        if (root.val == num) {

            levelOrderStoredInMap(root.left, 1, levelOrderMap);
            levelOrderStoredInMap(root.right, 1, levelOrderMap);

            return 1;
        }
        int k = solve(root.left, num);
        if (k > 0) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.right, k + 1, levelOrderMap);
            return k + 1;
        }
        k = solve(root.right, num);
        if (k > 0) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.left, k + 1, levelOrderMap);
            return k + 1;
        }
        return levelOrderMap.size();
    }

    public void levelOrderStoredInMap(TreeNode root, int k, Map<Integer, Set<Integer> > levelOrderMap) {
        if (root != null) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.left, k + 1,
                    levelOrderMap);
            levelOrderStoredInMap(root.right, k + 1,
                    levelOrderMap);
        }
    }

    private void storeRootAtK(TreeNode root, int k, Map<Integer, Set<Integer> > levelOrderMap) {
        if (levelOrderMap.containsKey(k)) {
            levelOrderMap.get(k).add(root.val);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(root.val);
            levelOrderMap.put(k, set);
        }
    }

    // Driver Code
    public static void main(String[] args) {

	/*  12
		/ \
	  	13 10
			/ \
		   14   15
		  / \   / \
	      21 24 22 23

		Let us create Binary Tree as shown
		above */
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);

//        Map<Integer, Set<Integer> > levelOrderMap = new HashMap<>();

        L31a_BurnBinaryTree tree=new L31a_BurnBinaryTree();
        int ans=tree.solve(root, 14);

        System.out.println(ans);
    }
}
