package tree.bst;

public class Main {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(2);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(6);
		root.left.right.right.left = new TreeNode(5);
		root.left.right.right.right = new TreeNode(7);
		
		/*
		 * 				 8
		 * 			   /  \
		 *            2    9
		 *           / \    
		 *          0   4    
		 *               \
		 *                6
		 *               / \
		 *              5   7
		 */
		
	}
}

