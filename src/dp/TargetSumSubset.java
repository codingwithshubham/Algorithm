package dp;
import java.util.*;

/*
 *  You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.
 */

public class TargetSumSubset {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] input = new int[n];
        
        for(int i=0; i<n; i++){
            input[i] = sc.nextInt();
        }
        
        int tar = sc.nextInt();
        
        System.out.println(isSubsetFound(input, tar));
    }
    
    static boolean isSubsetFound(int[] input, int tar){
        
        int[] dp = new int[tar+1];
        
        dp[0] = 1;
        
        for(int i=0; i<input.length; i++){
            int[] cdp = new int[dp.length];
            for(int j=input[i]; j<cdp.length; j++){
                
                if(dp[j-input[i]] == 1)
                    cdp[j] = 1;
            }
            
            for(int i1=0; i1<dp.length; i1++){
                if(cdp[i1] == 1)
                    dp[i1] = 1;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[tar]==1;
    }
}
