package tree;
import java.util.*;

public class Preorder {
	
	public static void traverse(TreeNode root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			traverse(root.left);
			traverse(root.right);
		}
	}
	
	public static void traverse2(TreeNode root) {
		Stack<Pair> stack = new Stack();
		stack.push(new Pair(root, 0));
		
		while(!stack.isEmpty()) {
			
			stack.peek().state++;
			
			if(stack.peek().state == 1) {
				
				System.out.print(stack.peek().node.data+" ");
				
				if(stack.peek().node.left != null)
					stack.push(new Pair(stack.peek().node.left, 0));
				
			}
			else if(stack.peek().state == 2) {
				if(stack.peek().node.right != null)
					stack.push(new Pair(stack.peek().node.right, 0));
			}
			else {
				stack.pop();
			}
			
		}
	}

}
