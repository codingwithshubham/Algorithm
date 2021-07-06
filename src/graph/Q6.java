package graph;
import java.util.*;
/*
 * detect cycle directed
 */

public class Q6 {
	
	// using topological sort khan's algo
	public boolean isCyclicBFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int[] indegree = new int[V];
        
        for(ArrayList<Integer> l : adj){
            for(int i: l){
                indegree[i]++;
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            list.add(node);
            
            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0)
                    queue.offer(i);
            }
        }
        
        if(list.size() == V)
            return false;
            
        return true;
    }
	
	
	public boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int[] visited = new int[V];
        
        int[] dfsVis = new int[V];
        
        for(int i=0; i<V; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(dfs(i, visited, dfsVis, adj))
                    return true;
            }
        }
        
        return false;
    }
    
    boolean dfs(int node, int[] visited, int[]dfsVis, ArrayList<ArrayList<Integer>> adj){
        
        dfsVis[node] = 1;
        
        for(int i: adj.get(node)){
            if(visited[i] == 0){
                visited[i] =1;
                if(dfs(i, visited, dfsVis, adj))
                    return true;
            }
            else if(dfsVis[i] == 1)
                return true;
        }
        
        dfsVis[node] = 0;
        
        return false;
    }

}
