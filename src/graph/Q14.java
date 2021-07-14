package graph;
/*
 * 
 * leetcode 953. Verifying an Alien Dictionary
 * 
 * In an alien language, surprisingly they also use english lowercase letters, 
 * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
	Given a sequence of words written in the alien language, and the order of the alphabet, 
	return true if and only if the given words are sorted lexicographicaly in this alien language.
 * 
 */

public class Q14 {
	
public boolean isAlienSorted(String[] words, String order) {
        
        int[] pos = new int[26];
        
        for(int i=0; i<order.length(); i++){
            pos[order.charAt(i)-'a'] = i;
        }
        
        for(int i=0; i<words.length-1; i++){
            
            String s1 = words[i];
            String s2 = words[i+1];
            
            int j=0;
           // boolean temp = false;
            
            for(; j<s1.length(); j++){
                if(j>s2.length()-1)
                    return false;
                else if(pos[s1.charAt(j)-'a'] > pos[s2.charAt(j)-'a'])
                    return false;
                else if(pos[s1.charAt(j)-'a'] < pos[s2.charAt(j)-'a']){
                    break;
                }
                    
                    
            }
            // if(j>0 && !temp && s2.length()<s1.length())
            //     return false;                

        }
        
        return true;
        
    }

}
