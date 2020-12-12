package dp;
import java.util.*;

/*
 * 1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again 
                  and again.
 */

public class UnboundedKnapsack {
	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] values = new int[n];
        for(int i=0; i<n; i++){
            values[i] = sc.nextInt();
        }
        
        int[] weight = new int[n];
        
        for(int i=0; i<n; i++){
            weight[i] = sc.nextInt();
        }
        
        int cap = sc.nextInt();
        
        System.out.println(maxValue(values, weight, cap));
    }
    
    static int maxValue(int[] values, int[] weight, int cap){
        
        int[] dp = new int[cap+1];
        
        //item
        for(int i=0; i<weight.length; i++){
            
            // int[] cdp = new int[dp.length];
            //cap
            for(int j=1; j<dp.length; j++){
                if(weight[i] <= j){
                    dp[j] = Math.max(values[i] + dp[j-weight[i]], dp[j]);
                }
            }
            
            // for(int i1=0; i1<dp.length; i1++){
            //     if(cdp[i1] > dp[i1])
            //         dp[i1] = cdp[i1];
            // }
        }
        
        return dp[cap];
      
    }

}
