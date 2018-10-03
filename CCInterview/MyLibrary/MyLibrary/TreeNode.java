package MyLibrary;


// binary tree node
public class TreeNode {

    public int data;
    public TreeNode left;    
    public TreeNode right; 
//    public TreeNode parent;
//    private int size = 0;


    public TreeNode(int d) {
        data = d;
//        size = 1;
    }

    
    private void setLeftChild(TreeNode left) {
        this.left = left;
//        if (left != null) {
//            left.parent = this;
//        }
    }

    
    private void setRightChild(TreeNode right) {
        this.right = right;
//        if (right != null) {
//            right.parent = this;
//        }
    }


    public static TreeNode createNodeFromArray(int arr[], int left, int right) {
        int len = right - left + 1; // +1 fills in the tree from the left node (?)
        if (len < 1) return null;

        int mid = left + len/2;

        //System.out.println ("mid= " + mid + "    left child: [" + left + ", " + (mid - 1) + "]");
        TreeNode leftChild = createNodeFromArray(arr, left, mid - 1);
        //System.out.println ("mid= " + mid + "    create root: " + arr[mid]);
        TreeNode root = new TreeNode (arr[mid]);
        //System.out.println ("mid= " + mid + "    right child: [" + (mid + 1) + ", " + right + "]");
        TreeNode rightChild = createNodeFromArray(arr, mid + 1, right);

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        return root;
    } 


    public static TreeNode createMinimalBST (int[] arr) {
        TreeNode tn = createNodeFromArray(arr, 0, arr.length-1);
        return tn;
    }


    public static void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.println (root.data);
        printInOrder(root.right);
    }


    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }


    private boolean isWithin (int min, int max) {
        //System.out.println ("  data= " + data + ";  ["+ min + ", " + max + "]");
        boolean left_ok = (left == null ? true : left.isWithin (min, data));
        boolean right_ok = (right == null ? true : right.isWithin (data, max));
        return  left_ok && right_ok && (data > min) && (data <= max);
    }


    public boolean isBST() {
       return left.isWithin(Integer.MIN_VALUE, data) && right.isWithin(data, Integer.MAX_VALUE);
    }


    public void print() {
        BTreePrinter.printNode(this);
    }
}