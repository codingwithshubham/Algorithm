package tree.binarytree;

/*
 *  vertical width of bt
 */
public class Q20 {

	//using recursive
	static int verticalWidth(TreeNode root) {
		int[] minmax = new int[] {0,0};
		
		helper(root, 0, minmax);
		
		return minmax[1]-minmax[0]+1;
	}
	
	static void helper(TreeNode node, int col ,int[]minmax) {
		
		if(node!=null) {
			minmax[0] = Math.min(minmax[0], col);
			minmax[1] = Math.min(minmax[1], col);
			
			helper(node.left, col-1, minmax);
			helper(node.right, col+1, minmax);
		}
	}
}
