package graph;
import java.util.*;

import java.util.ArrayList;
/*
 *  sssp in unweighted graph
 */
public class Q8 {
	
	// using bfs
	static int[] shortest(int src, int n, ArrayList<ArrayList<Integer>> adj) {
		
		int[] dis = new int[n];
		
		for(int i=0; i<n; i++) {
			dis[i] = 1000000000;
		}
		
		dis[src] = 0;
		
		int[] visited = new int[n];
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(src);
		visited[src] = 1;
		
		while(!queue.isEmpty()) {
			
			int u = queue.poll();
			
			for(int v: adj.get(u)) {
				
				if(visited[v] == 0) {
					visited[v] = 1;
					if(dis[u]+1 < dis[v])
						dis[v] = dis[u]+1;
					queue.offer(v);
				}
			}
		}
		
		return dis;
		
	}

}
