import java.util.*;

// remove string having other strings as prefix
public class Main
{
	public static void main(String[] args) {
		String[] str = {"ar", "arp", "fin", "finance", "lb", "win", "winner"}; // [app, like, the]
		
		Node root = new Node();
		
		for(String s: str){
		    updateTrie(root, s);
		}
		
		Set<String> set = new LinkedHashSet<>();
		
		for(String s: str){
		    StringBuilder sb = new StringBuilder();
		    Node ptr = root;
		    
		    for(char c: s.toCharArray()){
		        
		        sb.append(c);
		        if(!ptr.data[c-'a'].isEnd){
		            ptr = ptr.data[c-'a'];
		        } else {
		            break;
		        }
		    }
		    
		    set.add(sb.toString());
		}

		System.out.println(set);
	}
	
	static void updateTrie(Node root, String s){
	    Node ptr = root;
	    
	    for(char c: s.toCharArray()) {
	        if(ptr.data[c-'a'] == null){
	            ptr.data[c-'a'] = new Node();
	        }
	        
	        ptr = ptr.data[c-'a'];
	    }
	    
	    ptr.isEnd = true;
	}
}

class Node {
    Node[] data;
    boolean isEnd;
    
    Node() {
        data = new Node[26];
    }
}
