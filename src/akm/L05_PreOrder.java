package akm;

import java.util.ArrayList;
import java.util.List;

public class L05_PreOrder {
    static TreeNode root;

    private static void dfs(TreeNode node, List<Integer> preorder) {
        if(node == null) return;

        preorder.add(node.val);
        dfs(node.left, preorder);
        dfs(node.right, preorder);
    }
/***   program starts here ***/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        dfs(root, preorder);
        return preorder;
    }

//      Definition for a binary tree node.

    public static void main(String[] args) {
        init();
        System.out.println("preorderTraversal           : "+ preorderTraversal(root));

    }

    private static void init() {
        root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(8);

        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.right.right.left=new TreeNode(9);
        root.right.right.right=new TreeNode(10);
    }
}
