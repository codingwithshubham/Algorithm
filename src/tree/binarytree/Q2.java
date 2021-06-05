package tree.binarytree;
import java.util.*;
/*
 * array rep from root node
 */
public class Q2 {
	
	//recursive
	static void construct1(TreeNode root, Integer[] arr, int index) {
		
		if(root!=null) {
			arr[index] = root.data;
			construct1(root.left, arr, 2*index+1);
			construct1(root.right, arr, 2*index+2);
		}
	}
	
	//iterative
	static Integer[] construct2(TreeNode root) {
		
		Integer[] arr = new Integer[9];
		
		if(root != null) {
			
			LinkedList<TreeNode> queue = new LinkedList<>();
			LinkedList<Integer> idxQueue = new LinkedList<>();
			queue.offer(root);
			idxQueue.offer(0);
			
			while(!queue.isEmpty()) {
				
				TreeNode node = queue.poll();
				int idx = idxQueue.poll();
				
				arr[idx] = node.data;
				
				if(node.left!=null) {
					queue.offer(node.left);
					idxQueue.offer(2*idx+1);
				}
				
				if(node.right!=null) {
					queue.offer(node.right);
					idxQueue.offer(2*idx+2);
				}
					
			}
		}
		
		return arr;
		
	}

}
