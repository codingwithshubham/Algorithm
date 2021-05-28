package tree;
import java.util.*;
/*
 *  delete node from bt
 */
public class Q9 {
	
	public static TreeNode deletionBT(TreeNode root, int key){
        //Write your code here and return the root of the changed tree
        
        if(root!=null){
            
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            
            TreeNode tar=null, par=null, deep=null;
            
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                
                if(node.data == key)
                    tar = node;
                    
                if(node.left==null && node.right==null)
                    deep = node;
                
                if(node.left!=null){
                    if(node.left.left == null && node.left.right == null)
                        par = node;
                        
                    queue.offer(node.left);
                    
                }
                
                 if(node.right!=null){
                    if(node.right.left == null && node.right.right == null)
                        par = node;
                        
                    queue.offer(node.right);
                    
                }
                
            }
            
            if(tar != null){
                
                tar.data = deep.data;
                
                if(par == null)
                    return null;
                else{
                    if(par.left == deep)
                        par.left = null;
                    else
                        par.right = null;
                }
            }
        }
        
        return root;
    }

}
