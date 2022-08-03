package akm;

import java.util.HashMap;
import java.util.Map;

public class L34c_Construct_aBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
    public static void main (String[] args) {
        int[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
        int[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;

        L34c_Construct_aBinaryTree tree=new L34c_Construct_aBinaryTree();

        System.out.println("Inorder traversal of the constructed tree is");
        tree.buildTree(in,pre);
    }
}
