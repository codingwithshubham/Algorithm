package graph;
import java.util.*;
/*
 * prims algo
 */
public class Q10 {
	
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        int[] visited = new int[V];
        
        int[] weight = new int[V];
        
        for(int i=0; i<V; i++){
            weight[i] = Integer.MAX_VALUE;
        }
        weight[0] = 0;
        
        PriorityQueue<MyNode1> queue = new PriorityQueue<>();
        queue.offer(new MyNode1(0,0));
        
        while(!queue.isEmpty()){
            
            int node = queue.poll().v;
            visited[node] = 1;
            
            for(ArrayList<Integer> list: adj.get(node)){
                if(visited[list.get(0)]==0 && list.get(1) < weight[list.get(0)]){
                    weight[list.get(0)] = list.get(1);
                    queue.offer(new MyNode1(list.get(0), list.get(1)));
                    
                }
            }
        }
        
        int sum=0;
        
        for(int i=0; i<V; i++){
            sum+= weight[i];
        }
        
        return sum;
        
    }
}

class MyNode1 implements Comparable<MyNode1>{
    
    Integer v, w;
    
    MyNode1(int v, int w){
        this.v = v; 
        this.w = w;
    }
    
    public int compareTo(MyNode1 n){
        
        if(n.w.equals(w))
            return v.compareTo(n.v);
            
        return w.compareTo(n.w);
    }
}

