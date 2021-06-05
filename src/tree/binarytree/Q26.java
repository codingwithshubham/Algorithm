package tree.binarytree;
import java.util.*;
/*
 * right view of bt
 */

public class Q26 {
	
	static int maxlvl = 0;
	
	//recursive
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        rightView(root, 1, list);
        
        return list;
    }
    
    static void rightView(TreeNode node, int lvl, List<Integer> list){
        
        if(node!=null){
            
            if(maxlvl<lvl){
                list.add(node.data);
                maxlvl++;
            }
            
            rightView(node.right, lvl+1, list);
            rightView(node.left, lvl+1, list);
        }
    }

    //iterative
    public static List<Integer> rightSideView1(TreeNode root) {
        
        List<Integer> list = new ArrayList();
        if(root!=null){
            
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(null);
            
            TreeNode right = null;
            
            while(!queue.isEmpty()){
                
                TreeNode node = queue.poll();
                
                if(node!=null){
                    right = node;
                    if(node.left!=null)
                        queue.offer(node.left);

                    if(node.right!=null)
                        queue.offer(node.right);
                }
                else{
                    list.add(right.data);
                    
                    if(!queue.isEmpty())
                        queue.offer(null);
                }

            }
        }
        return list;
    }
}
