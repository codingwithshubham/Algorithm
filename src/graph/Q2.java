package graph;
import java.util.*;
/*
 * dfs
 */

public class Q2 {
	
	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
		
		ArrayList<Integer> list = new ArrayList<>();
		
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i])
				dfs(i, adj, visited, list);
		}
		return list;
	}
	
	static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
		
		visited[node] = true;
		list.add(node);
		
		for(int i: adj.get(node)) {
			if(!visited[i])
				dfs(i, adj, visited, list);
		}
	}

}
