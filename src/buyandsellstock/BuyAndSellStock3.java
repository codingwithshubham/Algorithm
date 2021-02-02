package buyandsellstock;

public class BuyAndSellStock3 {
    public int maxProfit(int[] prices) {
//         int[] dp = new int[prices.length];
        
//         for(int i=0; i<prices.length; i++)
//             dp[i] = -1;
        
//         return maxProfit1(0, prices, 2, dp);
        
        // return maxProfit2(prices);
        
        return maxProfit3(prices);
        
    }
    
    //recursion approach
    public int maxProfit1(int curDay, int[] prices, int trem, int[] dp){
        
        if(curDay==prices.length || trem==0)
            return 0;
        
        if(dp[curDay] != -1)
            return dp[curDay];
        
        int profit = 0;
        
        for(int sellDay=curDay+1; sellDay<prices.length; sellDay++){
            profit = Math.max(profit, prices[sellDay]-prices[curDay] + maxProfit1(sellDay+1, prices, trem-1, dp));
        }
        
        profit = Math.max(profit, maxProfit1(curDay+1, prices, trem, dp));
        
        return dp[curDay] = profit;
    }
    
    //state approach
    public int maxProfit2(int[] prices){
        
        int buyState1 = Integer.MIN_VALUE;
        int sellState1 = 0;
        int buyState2 = Integer.MIN_VALUE;
        int sellState2 = 0;
        
        for(int day=0; day<prices.length; day++){
            buyState1 = Math.max(buyState1, -prices[day]);
            sellState1 = Math.max(sellState1, buyState1+prices[day]);
            buyState2 = Math.max(buyState2, sellState1-prices[day]);
            sellState2 = Math.max(sellState2, buyState2+prices[day]);
        }
        
        return sellState2;
    }
    
    // approach3 right or left move
    public int maxProfit3(int[] prices){
        
        int minToBuy = Integer.MAX_VALUE;
        int maxProfitBySellingToday = 0;
        int maxToSell = Integer.MIN_VALUE;
        int maxProfitByBuyingToday = 0;
        
        int[] dp = new int[prices.length];
        
        for(int day=0; day<prices.length; day++){
            minToBuy = Math.min(minToBuy, prices[day]);
            maxProfitBySellingToday = Math.max(maxProfitBySellingToday, prices[day] - minToBuy);
            dp[day] = maxProfitBySellingToday;
            
        }
        
        for(int day=prices.length-1; day>=0; day--){
            
            maxToSell = Math.max(maxToSell, prices[day]);
            maxProfitByBuyingToday = Math.max(maxProfitByBuyingToday, maxToSell - prices[day]);
            
            dp[day] += maxProfitByBuyingToday;
        }
        
        int profit = Integer.MIN_VALUE;
        
        for(int day=0; day<dp.length; day++){
            profit = Math.max(profit, dp[day]);
        }
        
        return profit;
    }
}
