package graph;
import java.util.*;
/*
 *  single source shortest path in DAG
 */

public class Q7 {
	
	static int[] shortest(int src, int n, ArrayList<ArrayList<MyNode>> adj) {
     
     int[] dis = new int[n];
     for(int i=0; i<n; i++) {
    	 dis[i] = 1000000000;
     }
     
     dis[src] = 0;
     
     int[] topo = topoSortDFS(n, adj);
     
     int u=0;
     
     for(int i=0; i<n; i++) {
    	 if(topo[i] == src) {
    		 u=topo[i];
    		 break;
    	 }
     }
     
     for( ; u<topo.length; u++) {
    	 
    	 for(MyNode node: adj.get(u)) {
			if(dis[u] + node.w < dis[node.v])
    			dis[node.v] = dis[u]+node.w; 
    	 }
    	
     }
 
     return dis;
 }
 
 static int[] topoSortDFS(int V, ArrayList<ArrayList<MyNode>> adj) 
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
 
 static void dfs(int node, int[] visited, ArrayList<ArrayList<MyNode>> adj, Stack<Integer> stack){
     
     for(MyNode n: adj.get(node)){
    	 int i = n.v;
    	 
         if(visited[i] == 0){
             visited[i] = 1;
             dfs(i, visited, adj, stack);
         }
     }
     
     stack.push(node);
 }


}

class MyNode{
	int v, w;
	
	MyNode(int v, int w){
		this.v = v;
		this.w = w;
	}
}
