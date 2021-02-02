package buyandsellstock;

/*
 * leetcode buy and sell stocks2
 */
public class BuyAndSell2 {
    public int maxProfit(int[] prices) {
//         int[] dp = new int[prices.length];
        
//         for(int i=0; i<prices.length; i++)
//             dp[i] = -1;
        
//         return maxProfit1(0, prices, dp);
        
        // return maxProfit2(prices);
        
        return maxProfit3(prices);
    }
    
    //recursion approch
    public int maxProfit1(int curDay, int[] prices, int[] dp){
        
        if(curDay == prices.length)
            return 0;
        if(dp[curDay] != -1)
            return dp[curDay];
        
        int profit = 0;
        for(int sellDay=curDay+1; sellDay<prices.length; sellDay++){
            profit = Math.max(profit, prices[sellDay]-prices[curDay] + maxProfit1(sellDay+1, prices, dp));
        }
        
        profit = Math.max(profit, maxProfit1(curDay+1, prices, dp));
        
        return dp[curDay] = profit;
    }
    
    //state approach
    public int maxProfit2(int[] prices){
        int buyState = Integer.MIN_VALUE;
        int sellState = 0;
        
        for(int day=0; day<prices.length; day++){
            
            buyState = Math.max(buyState, sellState - prices[day]);
            sellState = Math.max(sellState, buyState + prices[day]);
        }
        
        return sellState;
    }
    
    //approach3 valley-peak approach
    public int maxProfit3(int[] prices){
        
        int profit = 0;
        
        for(int day=1; day<prices.length; day++){
            
            if(prices[day] > prices[day-1])
                profit += prices[day] - prices[day-1];
        }
        
        return profit;
    }
}