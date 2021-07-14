package graph;
import java.util.*;

/*
 * Labyrinth
 * You are given a map of a labyrinth, and your task is to find a path from start to end. 
 * You can walk left, right, up and down.

 */
public class Q13 {
	 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    int r = sc.nextInt();
	    int c = sc.nextInt();
	   
	    char[][] matrix = new char[r][c];
 
	    for(int i=0; i<r; i++){
	        
	        String s = sc.next();
	        
	        for(int j=0; j<c; j++){
	            matrix[i][j] = s.charAt(j);
	        }
	    }
		
        String s = "";
		
		boolean found = false;
		int i=0,j=0;
	    
	    for(i=0; i<r; i++){
	        for(j=0; j<c; j++){
	            if(matrix[i][j] == 'A'){
	         
	                found = true;
	                break;
	            }
	        }
	        if(found)
	           break;
	    }
        
        // ArrayList<String> paths = new ArrayList<>();
        String path = find(i, j, matrix);
        
		if(path.length() == 0)
			System.out.println("NO");
		else
			System.out.println("YES\n"+path.length()+"\n"+path);
		
    }
    
	
    static String find(int i, int j, char[][] matrix){
        
        LinkedList<Pair> queue = new LinkedList<>();
        String s="";
        
        //System.out.println("S"+i+ " "+j+" ");
 
        queue.offer(new Pair(i, j, s));
        
        
        while(!queue.isEmpty()){
            
            Pair pair = queue.poll();
            //System.out.println(pair);
            
             if(pair.i>=0 && pair.i<matrix.length && pair.j>=0 && pair.j<matrix[0].length && matrix[pair.i][pair.j]!='#'){
                 //System.out.println(matrix[pair.i][pair.j]);
                 if(matrix[pair.i][pair.j] == 'B'){
                     return pair.path;
                 }
                 else{
                     matrix[pair.i][pair.j] = '#';
                     queue.offer(new Pair(pair.i-1, pair.j, pair.path+"U"));
                     queue.offer(new Pair(pair.i+1, pair.j, pair.path+"D"));
                     queue.offer(new Pair(pair.i, pair.j-1, pair.path+"L"));
                     queue.offer(new Pair(pair.i, pair.j+1, pair.path+"R"));
                 }
             }
             
        }
        
        return s;
    }
	
}
 
class Pair{
    int i, j;
    String path;
    
    Pair(int i, int j, String path){
        this.i = i;
        this.j = j;
        this.path = path;
    }
    
    public String toString(){
        return i+" "+j+" "+path;
    }
}
