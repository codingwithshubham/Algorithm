package tree.binarytree;

import java.util.Arrays;

/*
 * depth from parent array
 */
public class Q32 {
	
	//recursive O(N) time O(N) Space
	public static int depth(int[] parent) {
		
		int max = -1;
		 
		int[] dp = new int[parent.length];
		
		for(int i=0; i<dp.length; i++)
			dp[i] = -1;
		
		for(int i=0; i<parent.length; i++) {
			max = Math.max(max,  depth1(i, parent, dp));
		}
		
		System.out.println(Arrays.toString(dp));
		return max;
	}
	
	static int depth1(int idx, int[] parent, int[] dp) {
		
		if(dp[idx] != -1)
			return dp[idx];
		
		if(parent[idx] == -1)
			dp[idx] = 1;
		else
			dp[idx] = depth1(parent[idx], parent, dp) + 1;
		
		return dp[idx];
	}


	//iterative O(N) time O(N) Space
	public static int depth2(int[] parent) {
		
		int max = -1;
		 
		int[] dp = new int[parent.length];
		
		for(int i=0; i<parent.length; i++) {
			
			if(parent[i] == -1) {
				dp[i] = 1;
			}
			else {
				int curDepth = 0;
				int j=i;
				
				while(dp[j]==0 && parent[j]!=-1) {
					curDepth++;
					j = parent[j];
				}
				
				curDepth += dp[j];
				
				dp[i] = curDepth;
			}
			
			max = Math.max(max,  dp[i]);
		}
		
		System.out.println(Arrays.toString(dp));
		return max;
	}
}
