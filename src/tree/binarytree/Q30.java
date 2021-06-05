package tree.binarytree;
import java.util.*;
/*
 * diagonal traversal of bt
 */
public class Q30 {
	
	//recursive
	static ArrayList<ArrayList<Integer>> diagonal(TreeNode root){
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		int[] minmax = {0,0};
		
		recursiveHelper(root, map, 0, minmax);
		
		
		for(int i=minmax[0]; i<=minmax[1]; i++) {
			list.add(map.get(i));
		}
		
		return list;
	}
	
	static void recursiveHelper(TreeNode node, HashMap<Integer, ArrayList<Integer>> map, int lvl, int[]minmax) {
		
		if(node!=null) {
			map.putIfAbsent(lvl, new ArrayList<>());
			
			map.get(lvl).add(node.data);
			
			minmax[0] = Math.min(minmax[0], lvl);
			minmax[1] = Math.max(minmax[1], lvl);
			
			recursiveHelper(node.right, map, lvl, minmax);
			recursiveHelper(node.left, map, lvl+1, minmax);
		}
	}
	
	
	//iterative
	static ArrayList<ArrayList<Integer>> diagonal1(TreeNode root){
		
		ArrayList<ArrayList<Integer>> list = new ArrayList();
		
		if(root!=null) {
			LinkedList<TreeNode> queue = new LinkedList();
			queue.offer(root);
			queue.offer(null);
			
			ArrayList<Integer> l1 = new ArrayList();
			
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				
				if(node!=null) {
					
					while(node!=null) {
						l1.add(node.data);
						
						if(node.left!=null)
							queue.offer(node.left);
						
						node = node.right;
					}
				}
				else {
					list.add(l1);
					l1 = new ArrayList();
					
					if(!queue.isEmpty())
						queue.offer(null);
				}
				
				
			}
			
			
		}
		return list;
		
	}
	
	
}
