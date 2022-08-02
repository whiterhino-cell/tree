package akm;

// Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree
// It also handles cases even when n1 and n2 are not there in Tree

/* Class containing left and right child of current node and key */

public class L27c_LowestCommonAncestor{
    // Root of the Binary Tree
    Node root;
    static boolean v1 = false, v2 = false;

    Node findLCAUtil(Node node, int n1, int n2) {
        if (node == null)
            return null;
        Node temp=null;

        if (node.data == n1) {
            v1 = true;
            temp = node;
        }
        if (node.data == n2) {
            v2 = true;
            temp = node;
        }

        Node left_lca = findLCAUtil(node.left, n1, n2);
        Node right_lca = findLCAUtil(node.right, n1, n2);

        if (temp != null)
            return temp;

        if (left_lca != null && right_lca != null)
            return node;

        return (left_lca != null) ? left_lca : right_lca;
    }

    Node findLCA(int n1, int n2) {
        v1 = false;
        v2 = false;

        Node lca = findLCAUtil(root, n1, n2);

        if (v1 && v2)
            return lca;

        return null;
    }

    public static void main(String args[]) {
        L27c_LowestCommonAncestor tree = new L27c_LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }

    static class Node{
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}

