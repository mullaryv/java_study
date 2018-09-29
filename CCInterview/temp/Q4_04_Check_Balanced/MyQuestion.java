//package Q4_04_Check_Balanced;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class MyQuestion {

  private static int cnt = 0;

  public static int getHeight (TreeNode node, int h) {
    if (node == null) return h;
    
//    cnt++;   
    return Math.max (getHeight (node.left, h), getHeight (node.right, h)) + 1;
  }

  public static Boolean isBalanced (TreeNode r) {
    if (r == null) return true;
//    return Math.abs (getHeight (r.left, 1) - getHeight(r.right, 1)) < 2;
//    return false;

    if (Math.abs (getHeight (r.left, 1) - getHeight(r.right, 1)) < 2) {
      return isBalanced(r.left) && isBalanced(r.right);
    }
    else
      return false;
  }



  public static int getHeight2 (TreeNode r) {
    if (r == null) return 0;
    cnt++;   

    int hleft = getHeight2 (r.left);
    if (hleft == Integer.MIN_VALUE) return hleft;
    int hright = getHeight2 (r.right);
    if (hright == Integer.MIN_VALUE) return hright;

    if (Math.abs (hleft - hright) > 1) return Integer.MIN_VALUE;

    return Math.max (hleft, hright) + 1;
  }


  static void printTree (TreeNode root, String name, boolean p) {
        cnt = 0; 
	System.out.println("\n" + name);
	System.out.println("Root? " + root.data);
        int height = getHeight2(root);
	System.out.println("Tree height: " + height);
//	System.out.println("Is balanced? " + isBalanced(root));
	System.out.println("Is balanced? " + (height != Integer.MIN_VALUE));
	System.out.println("Visited: " + cnt);
        if (p) root.print();
        cnt = 0; 
  }

	public static void main(String[] args) {
		// Create balanced tree

//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		TreeNode root = TreeNode.createMinimalBST(array);
		printTree (root, "", false);
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		printTree (unbalanced, "", false);


		TreeNode custom = new TreeNode(1);
		TreeNode custom2 = new TreeNode(2);
		TreeNode custom3 = new TreeNode(3);
		TreeNode custom4 = new TreeNode(4);
		TreeNode custom5 = new TreeNode(5);
		TreeNode custom6 = new TreeNode(6);
		TreeNode custom7 = new TreeNode(7);
		TreeNode custom8 = new TreeNode(8);
/*
                custom.left = custom2;
                custom.right = custom3;
                custom2.left = custom4;
                custom2.right = custom5;
//                custom4.left = custom6;
//                custom4.right = custom7;
*/
                custom.left = custom2;
                custom.right = custom3;
                custom2.left = custom4;
                custom2.right = custom5;
                custom3.left = custom6;
                custom4.left = custom7;
                custom4.right = custom8;

		printTree (custom, "custom", true);
	}

}
