package tree.binarytree;
import java.util.*;
/*
 * construct tree from treeArray
 */

public class Q1 {
	
	//recursive
	static TreeNode construct1(Integer[] arr, int idx) {
		
		TreeNode root = null;
		
		if(idx<arr.length && arr[idx]!=null) {
			root = new TreeNode(arr[idx]);
			root.left = construct1(arr, 2*idx+1);
			root.right = construct1(arr, 2*idx+2);
		}
		
		return root;
		
	}

	//iterative
	static TreeNode construct2(Integer[] arr) {
		
		TreeNode root = null;
		
		if(arr[0] != null) {
			
			root = new TreeNode(arr[0]);
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			
			for(int idx=0; idx<arr.length && !queue.isEmpty(); idx++) {
				
				if(arr[idx] != null) {
					TreeNode node = queue.poll();
					
					if(2*idx+1<arr.length && arr[2*idx+1]!=null) {
						TreeNode left = new TreeNode(arr[2*idx+1]);
						queue.offer(left);
						node.left = left;
					}
					
					if(2*idx+2<arr.length && arr[2*idx+2]!=null) {
						TreeNode right = new TreeNode(arr[2*idx+2]);
						queue.offer(right);
						node.right = right;
					}
				}
			}
			
		}
		
		return root;
		
	}

}
