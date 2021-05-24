package tree;
import java.util.*;
/*
 * min height of binary tree
 */
public class Q6 {
	
	static int minHeight(TreeNode root) {
		
		int minHeight = -1; // leaves have 0 height
		
		if(root!=null) {
			
			if(root.left == null)
				minHeight = minHeight(root.right)+1;
			else if(root.right == null)
				minHeight = minHeight(root.left)+1;
			else
				minHeight = Math.min(minHeight(root.left), minHeight(root.right))+1;
			
		}
			
		return minHeight;
	}
	
	static int minHeight2(TreeNode root) {
		
		int minHeight = 0;
		
		if(root!=null) {
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			queue.offer(null);
			
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				
				if(node!=null) {
					if(node.left==null && node.right==null) {
						minHeight++;
						break;
					}
					if(node.left!=null)
						queue.offer(node.left);
					if(node.right!=null)
						queue.offer(node.right);
				}
				else {
					minHeight++;
					if(!queue.isEmpty()) {
						queue.offer(null);
					}
				}
			}
		}
		return minHeight-1;
	}
}
