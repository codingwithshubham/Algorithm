package patterns;
/*

				*	
			*	*	
		*	*	*	
	*	*	*	*	
*	*	*	*	*	
		
*/
import java.util.*;

public class Pattern3 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sp = n-1;
        
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=sp; j++) {
        		System.out.print("\t");
        	}
        	
        	for(int j=1; j<=i; j++) {
        		System.out.print("*\t");
        	}
        	
        	sp--;
        	System.out.println();
        	
        }
	}
}
