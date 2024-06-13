/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> l1 = new ArrayList<>();
		Collections.addAll(l1, 0,1,10);
		
		List<Integer> l2 = new ArrayList<>();
		Collections.addAll(l2, 1,0,1);
		
		List<Integer> l3 = new ArrayList<>();
		Collections.addAll(l3, 1,2,5);
		
		List<Integer> l4 = new ArrayList<>();
		Collections.addAll(l4, 2,0,5);
		
	
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		
		System.out.println(find(list));
	}
	
	static int find(List<List<Integer>> list){
	   Map<Integer, Integer> map = new HashMap<>();
	   
	   for(List<Integer> l1: list){
	       map.putIfAbsent(l1.get(0), 0);
	       map.putIfAbsent(l1.get(1), 0);
	       
	       map.put(l1.get(0), map.get(l1.get(0))-l1.get(2));
	       map.put(l1.get(1), map.get(l1.get(1))+l1.get(2));
	   }
	   
	   Map<Integer, Integer> pos = new HashMap<>();
	   Map<Integer, Integer> neg = new HashMap<>();
	   
	   for(int key: map.keySet()){
	       if(map.get(key) > 0){
	           pos.put(key, map.get(key));
	       } else {
	           neg.put(key, map.get(key));
	       }
	   }
	   
	   //System.out.println(pos);
	   //System.out.println(neg);
	   
	   
	   return find(pos, neg);
	}
	
	static int find(Map<Integer, Integer> pos, Map<Integer, Integer> neg){
	   // System.out.println("S "+pos+" "+neg);
	    if(pos.size() == 0 && neg.size() == 0){
	       // System.out.println("CALL");
	        return 0;
	    }
	    
	    int count = 10000000;
	    
	    for(int key1: pos.keySet()){
	        for(int key2: neg.keySet()) {
	            Map<Integer, Integer> nPos = new HashMap(pos);
	            Map<Integer, Integer> nNeg = new HashMap(neg);
	            
	           // System.out.println(key1+" "+key2+" ");
	            
	            if(pos.get(key1) == -neg.get(key2)){
	                nPos.remove(key1);
	                nNeg.remove(key2);
	                count = Math.min(count, find(nPos, nNeg));
	            } else if(pos.get(key1) > -neg.get(key2)){
	                nPos.put(key1, pos.get(key1) + neg.get(key2));
	                nNeg.remove(key2);
	                count = Math.min(count, find(nPos, nNeg)+1);
	            } else {
	                nNeg.put(key2, neg.get(key2) + pos.get(key1));
	                nPos.remove(key1);
	                count = Math.min(count, find(nPos, nNeg)+1); 
	            }
	        }
	    }
	    
	    return count;
	}
}
