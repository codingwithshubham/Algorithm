package tree;
import java.util.*;

/*
 * max in binary tree
 */
public class Q3 {
	
	//recursive
	static int max(TreeNode root) {
		if(root!=null) {
			int leftmax = max(root.left);
			int rightmax = max(root.right);
			return Math.max(root.data, Math.max(leftmax, rightmax));
		}
		
		return 0;
	}
	
	//iterative
	static int max2(TreeNode root) {
		int max = 0;
		
		if(root == null)
			return 0;
		
		Stack<Pair> stack = new Stack();
		stack.push(new Pair(root, 0));
		
		while(!stack.isEmpty()) {
			
			stack.peek().state++;
			
			if(stack.peek().state == 1) {
				if(stack.peek().node.data > max)
					max = stack.peek().node.data;
				
				if(stack.peek().node.left != null) 
					stack.push(new Pair(stack.peek().node.left, 0));
			}
			else if(stack.peek().state == 2) {
				
				if(stack.peek().node.right != null) 
					stack.push(new Pair(stack.peek().node.right, 0));
				
			}
			else
				stack.pop();
			
		}
		
		return max;

	}

}
