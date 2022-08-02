package akm;

public class Main {
    static TreeNode root;

    public static void main(String[] args) {
        init();
        callClasses();
    }

    private static void callClasses() {
        L05_PreOrder l05_preOrder =new L05_PreOrder();
        L06_InOrder l06_inOrder =new L06_InOrder();
        L07_PostOrder l07_postOrder =new L07_PostOrder();
        L08_LevelOrderTraversal l08_levelOrderTraversal=new L08_LevelOrderTraversal();

        System.out.println("preorderTraversal           : "+ l05_preOrder.preorderTraversal(root));
        System.out.println("inorderTraversal            : "+ l06_inOrder.inorderTraversal(root));
        System.out.println("postorderTraversal          : "+ l07_postOrder.postorderTraversal(root));
        System.out.println("l08_levelOrderTraversal     : "+ l08_levelOrderTraversal.levelOrder(root));
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
