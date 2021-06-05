package tree.binarytree;
import java.util.*;

public class Levelorder {
	
	public static void traverse(TreeNode root) {
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		
		if(root!=null)
			queue.offer(root);
		
		while(!queue.isEmpty()) {
			if(queue.peek().left!=null)
				queue.offer(queue.peek().left);
			
			if(queue.peek().right!=null)
				queue.offer(queue.peek().right);
			
			System.out.print(queue.poll().data+" ");	
		}
		
	}

}
