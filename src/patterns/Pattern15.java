package patterns;
/*

		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	
		
*/
import java.util.*;

public class Pattern15 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sp =n/2;
        int st =1;
        int num = 1;
        
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=sp; j++) {
        		System.out.print("\t");
        	}
        	
        	int jnum = num;
        	
        	for(int j=1; j<=st; j++) {
        		System.out.print(jnum+"\t");
        		if(j<=st/2)
        			jnum++;
        		else
        			jnum--;
        	}
        	
        	if(i<=n/2) {
        		sp--;
        		st+=2;
        		num++;
        	}
        	else {
        		sp++;
        		st-=2;
        		num--;
        	}
        	
        	System.out.println();
        }
	}
}
