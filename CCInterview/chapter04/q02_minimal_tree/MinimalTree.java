import MyLibrary.TreeNode;

// Optimal BST
public class MinimalTree {	

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);

        //TreeNode.printInOrder(root);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
        root.print();
/*
        // test BST
        System.out.println("\ntest tree:");

        TreeNode a0 = new TreeNode(0); //0,1 -- true
        TreeNode a1 = new TreeNode(1); //1 -- true, 2 -- false
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7); //7,8 -- true; 9 -- false
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);

        a1.left = a0;
        a1.right = a2;
        a3.left = a1;
        a3.right = a4;

        a5.left = a3;
        a5.right = a8;
        a8.left = a6;
        a8.right = a9;

        a6.right = a7; // if left, false; 
        a5.print();
	    System.out.println(a5.isBST() ? "is BST" : "is not BST");
*/
    }
}
