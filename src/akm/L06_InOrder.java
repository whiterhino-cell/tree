package akm;

import java.util.ArrayList;
import java.util.List;

class L06_InOrder {
    private void dfs(TreeNode node, List<Integer> inorder) {
        if(node == null) return;

        dfs(node.left, inorder);
        inorder.add(node.val);
        dfs(node.right, inorder);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        dfs(root, inorder);
        return inorder;
    }
}

