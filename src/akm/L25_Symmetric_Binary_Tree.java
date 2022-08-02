package akm;

// Java implementation to check
// if Tree is symmetric or not
class L25_Symmetric_Binary_Tree{

    // A Binary Tree Node
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int val)
        {
            data = val;
            left = right = null;
        }
    };

    // Function to check if the given
// binary tree is Symmetric or not
    static boolean isSymmetric(Node root)
    {
        Node curr1 = root, curr2 = root;

        // Loop to traverse the tree in
        // Morris Traversal and
        // Reverse Morris Traversal
        while (curr1 != null &&
                curr2 != null)
        {

            if (curr1.left == null &&
                    curr2.right == null)
            {

                if (curr1.data != curr2.data)
                    return false;

                curr1 = curr1.right;
                curr2 = curr2.left;
            }

            else if (curr1.left != null &&
                    curr2.right != null)
            {
                Node pre1 = curr1.left;
                Node pre2 = curr2.right;

                while (pre1.right != null &&
                        pre1.right != curr1 &&
                        pre2.left != null &&
                        pre2.left != curr2)
                {
                    pre1 = pre1.right;
                    pre2 = pre2.left;
                }

                if (pre1.right == null &&
                        pre2.left == null)
                {

                    // Here, we are threading the Node
                    pre1.right = curr1;
                    pre2.left = curr2;
                    curr1 = curr1.left;
                    curr2 = curr2.right;
                }

                else if (pre1.right == curr1 &&
                        pre2.left == curr2)
                {

                    // Unthreading the nodes
                    pre1.right = null;
                    pre2.left = null;

                    if (curr1.data != curr2.data)
                        return false;
                    curr1 = curr1.right;
                    curr2 = curr2.left;
                }
                else
                    return false;
            }
            else
                return false;
        }

        if (curr1 != curr2)
            return false;

        return true;
    }

    // Driver Code
    public static void main(String[] args)
    {
	/*
	 5
	/ \
	3	 3
	/ \ / \
	8 9 9 8 */

        // Creation of Binary tree
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(9);
        root.right.left = new Node(9);
        root.right.right = new Node(8);

        if (isSymmetric(root))
            System.out.print("Symmetric");
        else
            System.out.print("Not Symmetric");
    }
}

// This code is contributed by Rajput-Ji

