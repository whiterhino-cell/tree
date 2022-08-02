package akm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L13a_allTraversals {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root == null) return post;

        while(!st.isEmpty()) {
            Pair it = st.pop();

            if(it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            } else if(it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            } else {
                post.add(it.node.val);
            }
        }
        return post;
    }
    class Pair {
        TreeNode node;
        int num;

        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
