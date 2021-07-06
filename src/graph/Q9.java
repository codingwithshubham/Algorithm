package graph;
import java.util.*;

import java.util.ArrayList;
/*
 *  dijkstra's,
 */
public class Q9 {
	
	//using pq i.e O(v+eloge)
	static void shortest(int src, int n, ArrayList<ArrayList<MyNode2>> adj) {
		
		int[] dis = new int[n];
	
	    for(int i=0; i<n; i++){
	        dis[i] = 1000000000;
	    }
	
	    dis[0] = 0;
	    
	    int[] visited = new int[n];
	
	    PriorityQueue<MyNode2> pq = new PriorityQueue<>();
	    pq.offer(new MyNode2(0, 0)); //src is 0
	
	
	    while(!pq.isEmpty()){
	        int node = pq.poll().v;
	        visited[node] = 1;
	
	        for(MyNode2 n1: adj.get(node)){
	            if(visited[n1.v] == 0){
	                int v = n1.v;
	                int w = n1.w;
	
	                if(dis[node]+w < dis[v]){
	                    dis[v] = dis[node]+w;
	                    pq.offer(n1);
	                }
	            }
	
	        }
	    }
	
	    for(int i=0; i<n; i++){
	        System.out.print(dis[i] + " ");
	    }
	
	}
	
	// using ts i.e O(V+ElogV) since tree size never greater than v thus logv for add,remove,contains
	static void shortest1(int src, int n, ArrayList<ArrayList<MyNode2>> adj) {
		
		int[] dis = new int[n];
	
	    for(int i=0; i<n; i++){
	        dis[i] = 1000000000;
	    }
	    
	    dis[0] = 0;
	
	    int[] visited = new int[n];
	
	   TreeSet<MyNode2> ts = new TreeSet<>();
	    ts.add(new MyNode2(0, 0)); //src is 0
	
	
	    Iterator<MyNode2> it;
	    
	    while(!ts.isEmpty()){
	    	
	    	it = ts.iterator();
	    	MyNode2 temp = it.next();
	    	ts.remove(temp);
	    	
	        int node = temp.v;
	        visited[node] = 1;
	
	        for(MyNode2 n1: adj.get(node)){
	            if(visited[n1.v] == 0){
	                int v = n1.v;
	                int w = n1.w;
	
	                if(dis[node]+w < dis[v]){
	                	
	                	if(ts.contains(new MyNode2(v, dis[v])))
	                		ts.remove(new MyNode2(v, dis[v]));
	                	
	                    dis[v] = dis[node]+w;
	                    ts.add(new MyNode2(v, dis[v]));
	                }
	            }
	
	        }
	    }
	
	    for(int i=0; i<n; i++){
	        System.out.print(dis[i] + " ");
	    }
	
	}
}

class MyNode2 implements Comparable<MyNode2>{
	Integer v, w;
	
	MyNode2(int v, int w){
	    this.v = v;
	    this.w = w;
	}

	public int compareTo(MyNode2 n){
	
	    if(n.w.equals(w))
	        return v.compareTo(n.v);
	
	    return w.compareTo(n.w);
	}

}

