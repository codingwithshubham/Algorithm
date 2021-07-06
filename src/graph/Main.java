package graph;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		int n = 6;
		
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(new ArrayList<Integer>());
		adj.get(0).get(0).add(1);
		adj.get(0).get(0).add(5);
		
		adj.get(0).add(new ArrayList<Integer>());
		adj.get(0).get(1).add(2);
		adj.get(0).get(1).add(3);
		
		
//		adj.get(0).add(new MyNode(1,5));
//		adj.get(0).add(new MyNode(2,3));
//		adj.get(1).add(new MyNode(3,6));
//		adj.get(1).add(new MyNode(2,2));
//		adj.get(2).add(new MyNode(4,4));
//		adj.get(2).add(new MyNode(5,2));
//		adj.get(2).add(new MyNode(3,7));
//		adj.get(3).add(new MyNode(4,-1));
//		adj.get(4).add(new MyNode(5,-2));
//		
//		int[] dis = Q7.shortest(3, n, adj);
		
		System.out.println(Q11.spanningTree(n, adj));
		
	}
	
}
