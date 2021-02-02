package buyandsellstock;

public class BuyAndSell4 {
    public int maxProfit(int k, int[] prices) {
//         int[][] dp = new int[prices.length][k];
        
//         for(int i=0; i<prices.length; i++)
//             for(int j=0; j<k; j++)
//                 dp[i][j] = -1;
        
//         return maxProfit1(0, prices, k, dp);
        
        return maxProfit2(prices, k);
        
    }
    
    //recursion approach
    public int maxProfit1(int curDay, int[] prices, int k, int[][] dp){
        
        if(curDay==prices.length || k==0)
            return 0;
        
        if(dp[curDay][k-1] != -1)
            return dp[curDay][k-1];
        
        int profit = 0;
        
        for(int sellDay=curDay+1; sellDay<prices.length; sellDay++){
            profit = Math.max(profit, prices[sellDay]-prices[curDay] + maxProfit1(sellDay+1, prices, k-1, dp));
        }
        
        profit = Math.max(profit, maxProfit1(curDay+1, prices, k, dp));
        
        return dp[curDay][k-1] = profit;
    }
    
    //state approach
    public int maxProfit2(int[] prices, int k){
        if(k==0 || prices.length==0)
            return 0;
        
        int[] dp = new int[2*k];
        for(int i=0; i<dp.length; i++){
            if(i%2 == 0)
                dp[i] = Integer.MIN_VALUE;
            else
                dp[i] = 0;
        }
        
        for(int day=0; day<prices.length; day++){
            for(int j=0; j<dp.length; j++){
                
                if(j==0)
                    dp[j] = Math.max(dp[j], -prices[day]);
                else if(j%2 == 0)
                    dp[j] = Math.max(dp[j], dp[j-1]-prices[day]);
                else
                    dp[j] = Math.max(dp[j], dp[j-1]+prices[day]);
            }
        }
        
        return dp[dp.length-1];
    }
}
