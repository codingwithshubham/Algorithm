package tree.binarytree;
import java.util.*;
/*
 * height or max height of binary tree
 */

public class Q7 {
	
	static int height(TreeNode root) {
		
		int height = -1;
		
		if(root!=null) {
			height =  Math.max(height(root.left), height(root.right))+1;
		}
		
		return height;
	}
	
	static int height2(TreeNode root) {
		int height = 0;
		
		if(root!=null) {
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			queue.offer(null);
			
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				
				if(node!=null) {
					if(node.left!=null)
						queue.offer(node.left);
					if(node.right!=null)
						queue.offer(node.right);
				}
				else {
					height++;
					if(!queue.isEmpty())
						queue.offer(null);
				}
			}
			
		}
		return height-1;
	}

}
