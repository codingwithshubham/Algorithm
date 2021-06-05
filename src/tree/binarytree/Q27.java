package tree.binarytree;
import java.util.*;
/*
 * top view of bt
 */

public class Q27 {
	
	static ArrayList<Integer> topView(TreeNode root){
        
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] minmax = {0,0};
        
        LinkedList<Pair4> queue = new LinkedList<>();
        queue.offer(new Pair4(0, root));
        
        while(!queue.isEmpty()){
            
            Pair4 p = queue.poll();
            TreeNode node = p.node;
            int col = p.col;
            
            map.putIfAbsent(col, node.data);
            
            minmax[0] = Math.min(minmax[0], col);
            minmax[1] = Math.max(minmax[1], col);
            
            if(node.left!=null)
                queue.offer(new Pair4(col-1, node.left));
                
            if(node.right!=null)
                queue.offer(new Pair4(col+1, node.right));
                
        }
        
        for(int i=minmax[0]; i<=minmax[1]; i++){
            list.add(map.get(i));
        }
        
        return list;
        
    }
}

class Pair4{
        int col;
        TreeNode node;
        
        Pair4(int c, TreeNode n){
            col = c;
            node = n;
        }
    }

