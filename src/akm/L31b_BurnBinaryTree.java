package akm;

import java.util.*;

//Burn_the_binary_tree_starting_from_the_target_node
public class L31b_BurnBinaryTree {

    public int solve(TreeNode A, int B) {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode targetNode = bfsToMapParents(A, mpp, B);
        int maxi = findMaxDistance(mpp, targetNode);
        return maxi;
    }

//    sabka parrent nikalenge with target ka node;
    private static TreeNode bfsToMapParents(TreeNode root,
                 HashMap<TreeNode, TreeNode> mpp, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode targetNode = new TreeNode(-1);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == start) targetNode = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return targetNode;
    }
    private static int findMaxDistance(HashMap<TreeNode, TreeNode> mpp, TreeNode targetNode){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetNode);
        HashMap<TreeNode,Integer> vis = new HashMap<>();
        vis.put(targetNode, 1);
        int maxi = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;

            for(int i = 0;i<sz;i++) {
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }



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
        akm.TreeNode root = new akm.TreeNode(12);
        root.left = new akm.TreeNode(13);
        root.right = new akm.TreeNode(10);
        root.right.left = new akm.TreeNode(14);
        root.right.right = new akm.TreeNode(15);
        akm.TreeNode left = root.right.left;
        akm.TreeNode right = root.right.right;
        left.left = new akm.TreeNode(21);
        left.right = new akm.TreeNode(24);
        right.left = new akm.TreeNode(22);
        right.right = new akm.TreeNode(23);

        // Utility map to store the sequence of burning
        // nodes
        Map<Integer, Set<Integer> > levelOrderMap = new HashMap<>();

        L31b_BurnBinaryTree tree=new L31b_BurnBinaryTree();
        System.out.println(tree.solve(root, 14));

        // will print the sequence of burning nodes
//        System.out.println(14);
        for (Integer level : levelOrderMap.keySet()) {
            for (Integer val : levelOrderMap.get(level)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }


}
