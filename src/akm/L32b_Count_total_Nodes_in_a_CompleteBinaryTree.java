package akm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L32b_Count_total_Nodes_in_a_CompleteBinaryTree {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        if(left == right) return ((2<<(left)) -1);
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }


    public int getHeightLeft(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }


    public int getHeightRight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }
    public static void main(String[] args) {

	  /* 12
		/ \
		13 10
			/ \
			14 15
			/ \ / \
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


        Map<Integer, Set<Integer> > levelOrderMap = new HashMap<>();

        L32b_Count_total_Nodes_in_a_CompleteBinaryTree tree=new L32b_Count_total_Nodes_in_a_CompleteBinaryTree();
//        tree.countNodes(root, 14, levelOrderMap);

        System.out.println(14);
        for (Integer level : levelOrderMap.keySet()) {
            for (Integer val : levelOrderMap.get(level)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
