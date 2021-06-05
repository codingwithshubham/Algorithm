package tree.binarytree;
import java.util.*;
/*
 * vertical order of bt
 */
public class Q19 {

	//iterative bfs/levelorder (complex)
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root!=null){
            LinkedList<Pair2> queue = new LinkedList<>();
            queue.offer(new Pair2(0, 0, root));
            
            TreeMap<Integer, ArrayList<Pair2>> map = new TreeMap<>(); 
            
            while(!queue.isEmpty()){
                Pair2 pair = queue.poll();
                int col = pair.col;
                int row = pair.row;
                TreeNode node = pair.node;
                
                if(map.containsKey(col)){
                    ArrayList<Pair2> set = map.get(col);
                    set.add(pair);
                }
                else{
                    ArrayList<Pair2> set = new ArrayList();
                    set.add(pair);
                    map.put(col, set);
                }
                
                if(node.left!=null){
                    queue.offer(new Pair2(row+1, col-1, node.left));
                }
                
                if(node.right!=null){
                    queue.offer(new Pair2(row+1, col+1, node.right));
                }
            }
            List<List<Integer>> list = new ArrayList();
            
            Set<Map.Entry<Integer, ArrayList<Pair2>>> entries = map.entrySet(); 
            Iterator<Map.Entry<Integer, ArrayList<Pair2>>> i = entries.iterator();
            
            while(i.hasNext()){
                Map.Entry<Integer, ArrayList<Pair2>> entry = i.next();
                Collections.sort(entry.getValue(), new MyComparator());
                
                List<Integer> l1 = new ArrayList<>();
                Iterator<Pair2> i1 = entry.getValue().iterator();
                
                while(i1.hasNext()){
                    l1.add(i1.next().node.data);
                }
                
                list.add(l1);
            }
            
            //System.out.println(list);
            return list;
            
        }
        return null;
    }

	//iterative bfs/levelorder (good coding way)
	public static List<List<Integer>> verticalTraversal1(TreeNode root) {
        
        if(root!=null){
            LinkedList<Pair2> queue = new LinkedList<>();
            queue.offer(new Pair2(0, 0, root));
            
            HashMap<Integer, ArrayList<Pair2>> map = new HashMap<>(); 
            int min=0, max=0;
            
            while(!queue.isEmpty()){
                Pair2 pair = queue.poll();
                int col = pair.col;
                int row = pair.row;
                TreeNode node = pair.node;
                
                map.putIfAbsent(col, new ArrayList());
                map.get(col).add(new Pair2(row, col, node));
                
                min = Math.min(min, col);
                max = Math.max(max, col);
                
                if(node.left!=null){
                    queue.offer(new Pair2(row+1, col-1, node.left));
                }
                
                if(node.right!=null){
                    queue.offer(new Pair2(row+1, col+1, node.right));
                }
            }
            List<List<Integer>> list = new ArrayList();
            
            for(int i=min; i<=max; i++){
                
                Collections.sort(map.get(i), new MyComparator());
                List<Integer> l1 = new ArrayList();
                
                for(Pair2 j: map.get(i)){
                    l1.add(j.node.data);
                }
                
                list.add(l1);
            }
            
            return list;
            
        }
        return null;
    }
	
	//recursive dfs/preorder
    public static List<List<Integer>> verticalTraversal2(TreeNode root) {
        
        int[] c = new int[]{0,0};
        int[] r = new int[]{0,0};
        HashMap<Integer, HashMap<Integer, List<Integer>>> map = new HashMap();
        
        helper(root, 0, 1, c, r, map);
        
        List<List<Integer>> list = new ArrayList();
        
        for(int i=c[0]; i<=c[1]; i++){
           
            List<Integer> l1 = new ArrayList();
            
            for(int j=r[0]; j<=r[1]; j++){
                
                if(map.get(i).containsKey(j)){
                    Collections.sort(map.get(i).get(j));
                    for(int k: map.get(i).get(j)){
                        l1.add(k);
                    }
                }
                
            }
            list.add(l1);
        }
        
        return list;
        
    }
    
    static void helper(TreeNode node, int col, int row, int[] c,int[] r, HashMap<Integer, HashMap<Integer, List<Integer>>> map){
        if(node!=null){
            
            //Pair pair = new Pair(row, col, root);
            map.putIfAbsent(col, new HashMap());
            
            map.get(col).putIfAbsent(row, new ArrayList());
            map.get(col).get(row).add(node.data);
            
            c[0] = Math.min(col, c[0]);
            c[1] = Math.max(col, c[1]);
            r[0] = Math.min(row, r[0]);
            r[1] = Math.max(row, r[1]);
            
            
            helper(node.left, col-1, row+1, c, r, map);
            helper(node.right, col+1, row+1, c, r, map);
            
        }
    }

}




class MyComparator implements Comparator<Pair2>{
    
    public int compare(Pair2 p1, Pair2 p2){
        if(p1.row == p2.row)
            return new Integer(p1.node.data).compareTo(new Integer(p2.node.data));
        else
            return new Integer(p1.row).compareTo(new Integer(p2.row));
    }
}

class Pair2{
    
    int col;
    TreeNode node;
    int row;
    
    public String toString(){
        return this.node.data+"";
    }
    
    Pair2(int row, int col, TreeNode node){
        this.row = row;
        this.col = col;
        this.node = node;
    }
}