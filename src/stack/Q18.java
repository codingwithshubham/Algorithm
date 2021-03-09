package stack;

import java.util.ArrayDeque;
/*
 * Duplicate Brackets
 */
public class Q18 {

	public static boolean isDuplicate(String exp){
        
		ArrayDeque<Character> s = new ArrayDeque<>();
	    
	    for(int i=0; i<exp.length(); i++){
	        
	        char c = exp.charAt(i);
	        
	        if(c == ')'){
	            if(s.peek() == '(')
	                return true;
	            else{
	                while(s.peek()!='(')
	                    s.pop();
	                
	                s.pop();
	            }    
	        }
	        else
	            s.push(c);
	    }
	    
	    return false;
	}

}
