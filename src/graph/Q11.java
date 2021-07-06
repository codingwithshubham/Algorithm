package graph;
import java.util.*;
/*
 * kruskal's
 */

public class Q11 {
	
 static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        
        ArrayList<Edge> edges = new ArrayList<>();
        
        for(int u=0; u<V; u++){
            
            for(ArrayList<Integer> l: adj.get(u)){
                int v = l.get(0);
                int w = l.get(1);
                
                edges.add(new Edge(u, v, w));
            }
            
        }
        
        Collections.sort(edges);
        
        int[] par = new int[V];
        
        for(int i=0; i<V; i++){
            par[i] = -1;
        }
        
        int[] range = new int[V];
        
        int sum=0, e=1;
        
        //System.out.println(edges);
        
        ArrayList<Edge> mstEdges = new ArrayList<>();
        
        
        for(int i=0; i<edges.size() && e<=V-1; i++){
            
            int u = edges.get(i).u;
            int v = edges.get(i).v;
            int w = edges.get(i).w;
    
            if(find(u, par)!=find(v, par)){
                
            	sum+=w;
                union(u,v,range, par);
                e++; // edge added to mst
                mstEdges.add(edges.get(i));
            }
        }
        
        System.out.println("MST Edges "+mstEdges);
        return sum;
   
    }
    
    static int find(int u, int[] par){
        
        if(par[u] == -1)
            return u;
            
        par[u] = find(par[u], par); 
            
        return par[u];
        
    }
    
    static void union(int u, int v, int[] range, int[] par){
        int root1 = find(u, par);
        int root2 = find(v, par);
        
        if(range[root1] == range[root2]){
            par[root1] = root2;
            range[root2]++;
        }
        else if(range[root1]<range[root2]){
            par[root1] = root2;
        }
        else
            par[root2]=root1;
    }
}

class Edge implements Comparable<Edge>{
    
    Integer u, v, w;
    
    Edge(int u, int v, int w){
        this.u = u;
        this.v = v; 
        this.w = w;
    }
    
    public String toString(){
        return u+" "+v+" "+w;
    }
    
    public int compareTo(Edge e){

            
        return w.compareTo(e.w);
    }
}

