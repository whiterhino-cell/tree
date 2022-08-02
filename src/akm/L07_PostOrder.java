package akm;

import java.util.ArrayList;
import java.util.List;

public class L07_PostOrder {
    private void dfs(TreeNode node, List<Integer> postorder) {
        if(node == null) return;

        dfs(node.left, postorder);
        dfs(node.right, postorder);
        postorder.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        dfs(root, postorder);
        return postorder;
    }
}
