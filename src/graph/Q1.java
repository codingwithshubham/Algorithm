package graph;
import java.util.*;
/*
 * bfs
 */

public class Q1 {

	public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
		
		ArrayList<Integer> list = new ArrayList<>();
		
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				bfs(i, adj, visited, list);
			}
		}
		
		return list;
	}
	
	static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			list.add(v);
			
			for(int i: adj.get(v)) {
				if(!visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
					
			}
			
		}
	}
}
