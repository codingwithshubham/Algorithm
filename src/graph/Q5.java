package graph;
import java.util.*;

/*
 * topological sort
 */
public class Q5 {
	
	//kahn's algo
	static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int[] indegree = new int[V];
        
        
        for(ArrayList<Integer> l: adj){
            for(int i: l){
                indegree[i]++;
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        int[] arr = new int[V];
        int pt=0;
        
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            arr[pt] = node;
            pt++;
            
            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0)
                    queue.offer(i);
            }
        }
        
        // System.out.println(Arrays.toString(arr));

        return arr;
    }
	
	static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        
        int[] visited = new int[V];
        
        
        for(int i=0; i<V; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(i, visited, adj, stack);
            }
        }
       
        
        int[] arr = new int[V];
        
        
        for(int i=0; i<V && !stack.empty(); i++){
            arr[i] = stack.pop();    
        }
        
        
        return arr;
    }
    
    static void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        
        for(int i: adj.get(node)){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(i, visited, adj, stack);
            }
        }
        
        stack.push(node);
    }

}
