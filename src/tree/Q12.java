package tree;
import java.util.*;
/*
 * mirror of binary tree
 */
public class Q12 {

	//recursive
	public static TreeNode invertTree(TreeNode root) {
        
        if(root!=null){
            TreeNode node = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(node);
            
        }
        
        return root;
    }
	
	//iterative
	public static TreeNode invertTree1(TreeNode root) {
        
        if(root!=null){
            
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            
            while(!queue.isEmpty()){

            	TreeNode node = queue.poll();
                
                if(node.left!=null)
                    queue.offer(node.left);
                
                if(node.right!=null)
                    queue.offer(node.right);
                
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            
        }
        return root;

    }
}
