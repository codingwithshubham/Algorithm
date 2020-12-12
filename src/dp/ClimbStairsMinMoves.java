package dp;
import java.util.*;
/*
 	1. You are given a number n, representing the number of stairs in a staircase.
	2. You are on the 0th step and are required to climb to the top.
	3. You are given n numbers, where ith element's value represents - till how far from the step you 
	     could jump to in a single move.  You can of-course fewer number of steps in the move.
	4. You are required to print the number of minimum moves in which you can reach the top of 
	     staircase.
	Note -> If there is no path through the staircase print -1.
 */

public class ClimbStairsMinMoves {

	public static void main(String[] args) {
		int n = 10;
		int[] jumps = {3,3,0,2,1,2,4,2,0,0};
		
		System.out.println(minMoves(n, jumps));

	}
	
	static int minMoves(int n, int[] jumps) {
		int[] dp = new int[n+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i] = -1;
		}
		
		dp[n] = 0;
		
		
		for(int i=n-1; i>=0; i--) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=jumps[i]&&(i+j)<=n; j++) {
				if(dp[i+j]>=0) {
					min = Math.min(min, dp[i+j]);
				}
			}
			if(min!=Integer.MAX_VALUE)
				dp[i] = min+1;
		}
		
		return dp[0];
	}

}
