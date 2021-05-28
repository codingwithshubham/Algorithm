package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * left view of bt
 */
public class Q25 {

static int maxlvl = 0;
	
	//recursive
    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        leftView(root, 1, list);
        
        return list;
    }
    
    static void leftView(TreeNode node, int lvl, List<Integer> list){
        
        if(node!=null){
            
            if(maxlvl<lvl){
                list.add(node.data);
                maxlvl++;
            }
            
            leftView(node.left, lvl+1, list);
            leftView(node.right, lvl+1, list);
        }
    }

    //iterative
    public static List<Integer> leftSideView1(TreeNode root) {
        
        List<Integer> list = new ArrayList();
        if(root!=null){
            
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(null);
            
            TreeNode left = queue.peek();
            
            while(!queue.isEmpty()){
                
                TreeNode node = queue.poll();
                
                if(node!=null){
            
                    if(node.left!=null)
                        queue.offer(node.left);

                    if(node.right!=null)
                        queue.offer(node.right);
                }
                else{
                    list.add(left.data);
                    
                    if(!queue.isEmpty()) {
                    	queue.offer(null);
                    	left = queue.peek();
                    }
                        
                }

            }
        }
        return list;
    }
}
