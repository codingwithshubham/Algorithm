package tree;
import java.util.*;
/*
 * zigzag order/traversal of bt
 */

public class Q22 {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList();
        
        if(root!=null){
           
            LinkedList<TreeNode> queue = new LinkedList();
            queue.offer(root);
            queue.offer(null);
            
            int dir =1; //odd = right, even = left
            List<Integer> l1 = new ArrayList();
            
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                
                if(node!=null){
                    l1.add(node.data);
                    
                    if(node.left!=null)
                        queue.offer(node.left);

                    if(node.right!=null)
                        queue.offer(node.right);
                }
                else{
                    if(dir%2 == 0)
                        Collections.reverse(l1);
                    
                    list.add(l1);
                    
                    if(!queue.isEmpty()){
                        queue.offer(null);
                        dir++;
                        l1 = new ArrayList();
                    }
                       
                }
            }
             
        }
        
        return list;
        
    }
}
