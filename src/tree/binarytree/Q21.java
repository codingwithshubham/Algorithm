package tree.binarytree;
import java.util.*;
/*
 * Vertical sum of bt
 */

public class Q21 {

	public static ArrayList <Integer> verticalSum(TreeNode root) {
        // add your code here
        ArrayList<Integer>  list = new ArrayList<>();
        
        if(root!=null){
            HashMap<Integer, Integer> map = new HashMap<>();
            int min=0, max=0;
            LinkedList<Pair3> queue = new LinkedList<>();
            queue.offer(new Pair3(root, 0));
            
            while(!queue.isEmpty()){
                Pair3 pair = queue.poll();
                map.putIfAbsent(pair.col, 0);
                map.put(pair.col, map.get(pair.col)+pair.node.data);
                
                min = Math.min(min, pair.col);
                max = Math.max(max, pair.col);
                
                if(pair.node.left!=null)
                    queue.offer(new Pair3(pair.node.left, pair.col-1));
                    
                if(pair.node.right!=null)
                    queue.offer(new Pair3(pair.node.right, pair.col+1));
            }
            
            for(int i=min; i<=max; i++){
                list.add(map.get(i));
            }
        }
        return list;
    }
}

class Pair3{
    int col;
    TreeNode node;
    
    Pair3(TreeNode n, int c){
        col = c;
        node = n;
    }
}