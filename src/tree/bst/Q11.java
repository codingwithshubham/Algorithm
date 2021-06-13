package tree.bst;
import java.util.*;
/*
 * bt to bst by maitaining same structure
 */
public class Q11 {

	public static TreeNode convertBtToBst(TreeNode root) {
		
		if(root!=null) {
		
			ArrayList<Integer> list = new ArrayList<>();
			
			list = traverse(root);
			
			Collections.sort(list);
			
			root = convert(root, list, new int[] {0});
		}
		
		return root;
	}
	
	
	static TreeNode convert(TreeNode root, ArrayList<Integer> list, int[] index) {
		
		if(root!=null) {
			root.left = convert(root.left, list, index);
			root.data = list.get(index[0]);
			index[0]++;
			root.right = convert(root.right, list, index);
		}
		
		return root;
	}
	
	static ArrayList<Integer> traverse(TreeNode root){
		
		ArrayList<Integer> list = new ArrayList<>();
		
		if(root!=null) {
		
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			
			while(!queue.isEmpty()) {
				
				TreeNode node = queue.poll();
				list.add(node.data);
				
				if(node.left!=null)
					queue.offer(node.left);
				
				if(node.right!=null)
					queue.offer(node.right);
			}
		}
		
		return list;
	}
}
