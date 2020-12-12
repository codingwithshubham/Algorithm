package dp;
import java.util.*;

/*
 * 1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of combinations of the n coins using which the 
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of combinations and not permutations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
                  combination. You should treat them as 1 and not 3.
 */

public class CoinChangeComb {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] coins = new int[n];
        
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        
        int tar = sc.nextInt();
        
        System.out.println(combinations(coins, tar));
    }
    
    static int combinations(int[] coins, int tar){
        
        int[] dp = new int[tar+1];
        
        dp[0] = 1;
        
        for(int i=0; i<coins.length; i++){
            int coin = coins[i];
            for(int j=coin; j<dp.length; j++){
                int diff = j-coin;
                dp[j] += dp[diff];
            }
        }
        
        return dp[tar];
    }
}
