package graph;
import java.util.*;
/*
 * Alien Dictionary
 * 
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. 
 * Find the order of characters in the alien language.
 * 
 */

public class Q15 {

	 public String findOrder(String [] dict, int N, int K)
	    {
	        // Write your code here
	    
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        
	        for(int i=0; i<K; i++){
	            adj.add(new ArrayList<Integer>());
	        }
	        
	        for(int i=0; i<dict.length-1; i++){
	            
	            String s1 = dict[i];
	            String s2 = dict[i+1];
	            
	            for(int j=0; j<s1.length(); j++){
	                if(s1.charAt(j) != s2.charAt(j)){
	                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
	                    break;
	                }
	            }
	            
	        }
	        
	        int[] indegree = new int[K];
	        
	        for(ArrayList<Integer> edge: adj){
	            for(int e: edge){
	                indegree[e]++;
	            }
	            
	        }
	        
	        LinkedList<Integer> queue = new LinkedList<>();
	        
	        for(int i=0; i<K; i++){
	            if(indegree[i] == 0)
	                queue.offer(i);
	        }
	        
	        String order = "";
	        while(!queue.isEmpty()){
	            int node = queue.poll();
	            
	            order += (char)node+'a';
	            
	            for(int i: adj.get(node)){
	                indegree[i]--;
	                if(indegree[i] == 0)
	                    queue.offer(i);
	            }
	            
	        }
	        
	        return order;
	    }
}
