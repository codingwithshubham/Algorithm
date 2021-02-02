package buyandsellstock;

/*
 * leetcode buy and sell stocks
 */
public class BuyAndSell1 {
    public int maxProfit(int[] prices) {
        
//         int[] dp = new int[prices.length];
//         for(int i=0; i<dp.length; i++)
//             dp[i] = -1;
        
//         return maxProfit1(0, prices, dp);
        
//           return maxProfit2(prices);
        
        return maxProfit3(prices);
    }
    
    //using recursive approach
    public int maxProfit1(int curDay, int[] prices, int[] dp){
        
        if(curDay==prices.length)
            return 0;
        if(dp[curDay] != -1)
            return dp[curDay];
        
        int profit = 0;
        
        for(int sellDay=curDay+1; sellDay<prices.length; sellDay++){
            profit = Math.max(profit, prices[sellDay] - prices[curDay]);
        }
        
        profit = Math.max(profit, maxProfit1(curDay+1, prices, dp));
        
        return dp[curDay] = profit;
    }
    
    //using state approach
    public int maxProfit2(int[] prices){
        
        int buyState = Integer.MIN_VALUE;
        int sellState = 0;
        
        if(prices.length==0)
            return 0;
        
        for(int curDay=0; curDay<prices.length; curDay++){
            buyState = Math.max(buyState, -prices[curDay]);
            sellState = Math.max(sellState, buyState+prices[curDay]);
        }
        
        return sellState;
    }
    
    //using approach3
    public int maxProfit3(int[] prices){
        
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for(int curDay=0; curDay<prices.length; curDay++){
            min = Math.min(min, prices[curDay]);
            
            profit = Math.max(profit, prices[curDay] - min);
        }
        
        return profit;
    }
}
