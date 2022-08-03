package akm;

import java.util.LinkedList;
import java.util.Queue;

public class L36c_SerializeAndDe_SerializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("#,");
                continue;
            }
            res.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void main(String args[]) {
        // Let us construct a tree shown in the above figure
        L36c_SerializeAndDe_SerializeBinaryTree tree = new L36c_SerializeAndDe_SerializeBinaryTree();
        TreeNode root=new TreeNode();
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        String serialized = tree.serialize(root);
//        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the stored tree into root1
        TreeNode t = tree.deserialize(serialized);

//        System.out.println(
//                "Inorder Traversal of the tree constructed from serialized String:");
        inorder(t);
    }
    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

}
//20 8 22 4 12 n n n n 10 14 n n n n
//
//4 8 10 12 14 20 22

//20,8,22,4,12,#,#,#,#,10,14,#,#,#,#,
//
//4 8 10 12 14 20 22