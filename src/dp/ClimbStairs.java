package dp;

/*
 * Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {

	public static void main(String[] args) {
		int n =3;
		System.out.println(climbStairs(n));

	}
    public static int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        //base case
        dp[n] = 1;
        
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=2 && i+j<=n; j++){
                dp[i] += dp[i+j];
            }
        }
        
        return dp[0];
        
    }

}


