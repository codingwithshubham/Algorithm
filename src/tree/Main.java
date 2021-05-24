package tree;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		root.right.left.right = new TreeNode(5);
		root.right.left.right.left = new TreeNode(7);
		
		/*
		 * 				 1
		 * 			   /  \
		 *            2    3
		 *           /    / \
		 *          0     4  6
		 *         / \     \
		 *        8   9     5
		 *                 /
		 *                 7
		 */
		
//		Integer[] treeArr = new Integer[] {1,2,3,4,5,6,7,8,9};
//		
//		Integer[] arr = new Integer[9];
		
		//Test1.construct1(root, arr, 0);
		
		//System.out.println(Arrays.toString(Test1.construct2(Test1.construct4(new Integer[] {1,2,null,4,5,null,null,8,9}))));
	}
}
