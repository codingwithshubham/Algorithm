package tree;
import java.util.*;
/*
 * bottom view of bt
 */

public class Q28 {
	
	 public ArrayList <Integer> bottomView(TreeNode root){
	       
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] minmax = {0,0};
        
        LinkedList<Pair4> queue = new LinkedList<>();
        queue.offer(new Pair4(0, root));
        
        while(!queue.isEmpty()){
            
            Pair4 p = queue.poll();
            TreeNode node = p.node;
            int col = p.col;
            
            map.put(col, node.data);
            minmax[0] = Math.min(minmax[0], col);
            minmax[1] = Math.max(minmax[1], col);
            
            if(node.left!=null)
                queue.offer(new Pair4(col-1, node.left));
                
            if(node.right!=null)
                queue.offer(new Pair4(col+1, node.right));
                
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=minmax[0]; i<=minmax[1]; i++){
            list.add(map.get(i));
        }
        
        return list;
        
    }
}
    
 
