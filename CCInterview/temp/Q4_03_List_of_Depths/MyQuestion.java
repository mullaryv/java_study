//package Q4_03_List_of_Depths;

import CtCILibrary.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQuestion {

	public static void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
          if (root == null)
            return;

          LinkedList<TreeNode> list = null;
          if (lists.size() == level) {
            //System.out.println("level: " + level);
            list = new LinkedList<TreeNode>();
            lists.add(list);
          }
          else {
            list = lists.get(level);
          }
          list.add(root);
          createLevelLinkedListDFS(root.left, lists, level + 1);          
          createLevelLinkedListDFS(root.right, lists, level + 1);          
	}


	public static ArrayList<LinkedList<TreeNode>> createDFS(TreeNode root) {
          System.out.println ("Creating using DFS method"); 
          ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
          createLevelLinkedListDFS(root, lists, 0);
          return lists;
	}	


	public static void createLevelLinkedListBFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists) {
          LinkedList<TreeNode> list = new LinkedList<TreeNode>();
          if (root != null)
            list.add(root);

          while (list.size() != 0) {
            //System.out.println ("size: " + list.size());
            lists.add(list);
            LinkedList<TreeNode> parents = list;
            list = new LinkedList<TreeNode>();

            for (TreeNode parent : parents) {
              if (parent.left != null)
                list.add(parent.left);
              if (parent.right != null)
                list.add(parent.right);
            } 
          }
	}

	public static ArrayList<LinkedList<TreeNode>> createBFS(TreeNode root) {
          System.out.println ("Creating using BFS method"); 
          ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
          createLevelLinkedListBFS(root, lists);
          return lists;
	}	

	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> listDFS = createDFS(root);
		printResult(listDFS);
		ArrayList<LinkedList<TreeNode>> listBFS = createBFS(root);
		printResult(listBFS);
	}

}
