//package akm;
//
//import java.util.*;
//
////Burn_the_binary_tree_starting_from_the_target_node
//public class L31bb_BurnBinaryTree {
//
//    private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root,
//                                                           HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
//        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
//        q.offer(root);
//        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
//        while(!q.isEmpty()) {
//            BinaryTreeNode<Integer> node = q.poll();
//            if(node.data == start) res = node;
//            if(node.left != null) {
//                mpp.put(node.left, node);
//                q.offer(node.left);
//            }
//            if(node.right != null) {
//                mpp.put(node.right, node);
//                q.offer(node.right);
//            }
//        }
//        return res;
//    }
//    private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, BinaryTreeNode<Integer> target) {
//        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
//        q.offer(target);
//        HashMap<BinaryTreeNode<Integer>,Integer> vis = new HashMap<>();
//        vis.put(target, 1);
//        int maxi = 0;
//
//        while(!q.isEmpty()) {
//            int sz = q.size();
//            int fl = 0;
//
//            for(int i = 0;i<sz;i++) {
//                BinaryTreeNode<Integer> node = q.poll();
//                if(node.left != null && vis.get(node.left) == null) {
//                    fl = 1;
//                    vis.put(node.left, 1);
//                    q.offer(node.left);
//                }
//                if(node.right != null && vis.get(node.right) == null) {
//                    fl = 1;
//                    vis.put(node.right, 1);
//                    q.offer(node.right);
//                }
//
//                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
//                    fl = 1;
//                    vis.put(mpp.get(node), 1);
//                    q.offer(mpp.get(node));
//                }
//            }
//            if(fl == 1) maxi++;
//        }
//        return maxi;
//    }
//    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
//    {
//        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
//        BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
//        int maxi = findMaxDistance(mpp, target);
//        return maxi;
//    }
//
//
//    public static void main(String[] args) {
//
//	/*  12
//		/ \
//	  	13 10
//			/ \
//		   14   15
//		  / \   / \
//	      21 24 22 23
//
//		Let us create Binary Tree as shown
//		above */
//        TreeNode root = new TreeNode(12);
//        root.left = new TreeNode(13);
//        root.right = new TreeNode(10);
//        root.right.left = new TreeNode(14);
//        root.right.right = new TreeNode(15);
//        TreeNode left = root.right.left;
//        TreeNode right = root.right.right;
//        left.left = new TreeNode(21);
//        left.right = new TreeNode(24);
//        right.left = new TreeNode(22);
//        right.right = new TreeNode(23);
//
//        // Utility map to store the sequence of burning
//        // nodes
//        Map<Integer, Set<Integer> > levelOrderMap = new HashMap<>();
//
//        // search node and store the level order from that
//        // node in map
////        search(root, 14, levelOrderMap);
//
//        // will print the sequence of burning nodes
//        System.out.println(14);
//        for (Integer level : levelOrderMap.keySet()) {
//            for (Integer val : levelOrderMap.get(level)) {
//                System.out.print(val + " ");
//            }
//            System.out.println();
//        }
//
//    }
//
//
//}
