package graph;
import java.util.*;
/*
 * detect cycle
 */

public class Q3 {
	
	public static boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				if(cycleBFS(i, visited, adj))
					return true;
			}
		}
		
		return false;
		
	}
	
	public static boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i])
				if(cycleDFS(i, -1, visited, adj))
					return true;
		}
		
		return false;
		
		
	}
	
	static boolean cycleDFS(int node, int par, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		
		visited[node] = true;
		
		for(int i: adj.get(node)) {
			if(!visited[i]) {
				if(cycleDFS(i, node, visited, adj))
					return true;
			}
			else if(par!=i)
				return true;
		}
		
		return false;
	}
	
	static boolean cycleBFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> par = new LinkedList<>();
		
		queue.offer(node);
		par.offer(-1);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			
			int v = queue.poll();
			int p = par.poll();
			
			for(int i: adj.get(v)) {
				if(!visited[i]) {
					visited[i] = true;
					queue.offer(i);
					par.offer(v);
				}
				else if(i!=p)
					return true;
					
			}
		}
		
		return false;
		
	}

}
