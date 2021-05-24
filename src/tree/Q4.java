package tree;
import java.util.*;
/*
 * no. of leaves node
 */
public class Q4 {
	
	static int count(TreeNode root) {
		
		if(root!=null) {
			if(root.left == null && root.right == null)
				return 1;
			
			return count(root.left)+count(root.right);
		}
		
		return 0;
	}
	
	static int count2(TreeNode root) {
		int count=0;
		
		if(root!=null) {
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
	
				if(node.left==null && node.right==null)
					count++;
				else {
					if(node.left != null)
						queue.offer(node.left);
					
					if(node.right!=null)
						queue.offer(node.right);
				}
			}
		}
		return count;
	}

}
