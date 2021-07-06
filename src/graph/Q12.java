package graph;
/*
 * bellman ford
 */
public class Q12 {
	
	public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        
        int[] weight = new int[n];
        
        for(int i=0; i<n; i++){
            weight[i] = 1000000000;
        }
        
        weight[0] = 0;
        
        for(int i=0; i<n-1; i++){
            boolean ischanged = false;
            
            for(int j=0; j<edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                
                if(weight[u]+w < weight[v]){
                    weight[v] = weight[u]+w;
                    ischanged = true;
                }
            }
            
            if(!ischanged)
                return 0;
        }
        
         boolean ischanged = false;
            
        for(int j=0; j<edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
            
            if(weight[u]+w < weight[v]){
                weight[v] = weight[u]+w;
                ischanged = true;
            }
        }
        
        if(ischanged)
            return 1;
            
        return 0;
    }

}
