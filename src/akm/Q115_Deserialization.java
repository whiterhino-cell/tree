package akm;

import java.util.ArrayList;

public class Q115_Deserialization {
    static int Empty =-1;
    static int index=0;
    public static Node deserialization(ArrayList<Integer> arr) {
        if (index == arr.size()) {
            return null;
        }
        int val = arr.get(index);
        index++;
        if (val == Empty) {
            return null;
        }
        Node root = new Node(val);
        root.left = deserialization(arr);
        root.right = deserialization(arr);
        return root;
    }

    //inorder
    public static void inorder(Node root){
        if (root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        ArrayList<Integer> lis = new ArrayList<>();
        int[] arr = {10, 20, -1, -1, 30, -1, -1};
        for (int i = 0; i < arr.length; i++) {
            lis.add(arr[i]);
        }
        Node node = deserialization(lis);
        inorder(node);
    }
}