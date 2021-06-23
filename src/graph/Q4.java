package graph;
import java.util.*;
/*
 * is bipartite
 */
public class Q4 {
	
	public boolean isBipartiteBFS(int V, ArrayList<ArrayList<Integer>>adj){
 
		int[] visited = new int[V];
		for(int i=0; i<V; i++) {
			visited[i] = -1;
		}
		
		for(int i=0; i<V; i++) {
			if(visited[i] == -1) {
				if(!checkBFS(i, adj, visited))
					return false;
			}
		}
		
		return true;
    }
	
	public boolean isBipartiteDFS(int V, ArrayList<ArrayList<Integer>>adj){
		 
		int[] visited = new int[V];
		for(int i=0; i<V; i++) {
			visited[i] = -1;
		}
		
		for(int i=0; i<V; i++) {
			if(visited[i] == -1) {
				visited[i] = 0; //  intialise color of component node
				if(!checkDFS(i, adj, visited))
					return false;
			}
		}
		
		return true;
    }
	
	boolean checkDFS(int node, ArrayList<ArrayList<Integer>>adj, int[] visited) {
		
		
		for(int i: adj.get(node)) {
			if(visited[i] == -1) {
				visited[i] = visited[node]==0?1:0; // color child alternate of current node color
				if(!checkDFS(i, adj, visited))
					return false;
			}
			else if(visited[i] == visited[node])
				return false;
		}
		
		return true;
	}
		
	boolean checkBFS(int node, ArrayList<ArrayList<Integer>>adj, int[] visited) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		queue.offer(node);
		visited[node] = 0;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			for(int i: adj.get(v)) {
				if(visited[i] == -1) {
					visited[i] = visited[v]==0?1:0;
					queue.offer(i);
				}
				else if(visited[i] == visited[v])
					return false;
			}
		}
		
		return true;
	
	}

}
