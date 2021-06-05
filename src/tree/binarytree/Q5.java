package tree.binarytree;
import java.util.*;
/*
 * check if 2 trees are structurly identical
 */
public class Q5 {
	
	static boolean isIdentical(TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}
	
	//iterative
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
         if(p==null || q==null)
             return false;
        
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            LinkedList<TreeNode> queue1 = new LinkedList<>();
            queue1.offer(q);
            
            while(!queue.isEmpty() && !queue1.isEmpty()){
                //System.out.println(queue);
                TreeNode node = queue.poll();
                
                if(node.left!=null)
                    queue.offer(node.left);
                
                if(node.right!=null)
                    queue.offer(node.right);
                
                TreeNode node1 = queue1.poll();
                
                if(node1.left!=null)
                    queue1.offer(node1.left);
                
                if(node1.right!=null)
                    queue1.offer(node1.right);
   
                if((node1.data!=node.data)||(node1.left == null && node.left!=null) || (node1.right==null && node.right!=null)||(node1.left != null && node.left==null) || (node1.right!=null && node.right==null))
                     return false;
            }
    
        
        return true;
	}

}
