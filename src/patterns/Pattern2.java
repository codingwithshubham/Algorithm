package patterns;
/*
 
*	*	*	*	*	
*	*	*	*	
*	*	*	
*	*	
*	
		
*/
import java.util.*;

public class Pattern2 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        for(int i=1; i<=n; i++) {
        	for(int j=i; j<=n; j++) {
        		System.out.print("*\t");
        	}
        	System.out.println();
        }
	}

}
