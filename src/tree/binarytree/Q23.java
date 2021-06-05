package tree.binarytree;
import java.util.*;
/*
 *  boundary traversal of bt
 */

public class Q23 {

	static ArrayList <Integer> printBoundary(TreeNode node)
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		if(node!=null){
			
		    ArrayList<Integer> leafs = new ArrayList<>();
		    ArrayList<Integer> left = new ArrayList<>();
		    ArrayList<Integer> right = new ArrayList<>();
		    
		    getLeaf(node, leafs);
	        getLeft(node.left, left);
	        getRight(node.right, right);
	
	        list.add(node.data);
		    
		    for(int i=0; i<left.size(); i++){
		        list.add(left.get(i));
		    }
		
		    for(int i=0; i<leafs.size(); i++){
		        if(node.left!=null && i==0)
		            continue;
		        if(node.right!=null && i==leafs.size()-1)
		            continue;    
		            
		        list.add(leafs.get(i));
		    }
	
		    for(int i=right.size()-1; i>=0; i--){
		        list.add(right.get(i));
		    }
		}
	    
	    return list;
	}
	
	static void getLeft(TreeNode node, ArrayList<Integer> list){
	    
	    if(node!=null){
	        list.add(node.data);
	        
	        if(node.left!=null)
	            getLeft(node.left, list);
	        else
	            getLeft(node.right, list);
	    }
	}
	
	static void getRight(TreeNode node, ArrayList<Integer> list){
	    
	    if(node!=null){
	        list.add(node.data);
	        
	        if(node.right!=null)
	            getRight(node.right, list);
	        else
	            getRight(node.left, list);
	    }
	}
	
	static void getLeaf(TreeNode node, ArrayList<Integer> list){
	   
	   if(node!=null){
	       if(node.left == null && node.right==null)
	            list.add(node.data);
	       
	       getLeaf(node.left, list);
	       getLeaf(node.right, list);
	   }
	}
}
