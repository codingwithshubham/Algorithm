package buyandsellstock;

public class BuyAndSellWithCooldown {

	    public int maxProfit(int[] prices) {
//	         int[] dp = new int[prices.length];
//	         for(int i=0; i<dp.length; i++)
//	             dp[i] = -1;
	        
//	         return maxProfit1(0, prices, dp);
	        return maxProfit2(prices);
	    }
	    
	    //recursion approach
	    public int maxProfit1(int curDay, int[] prices, int[] dp){
	        
	        if(curDay >= prices.length)
	            return 0;
	        
	        if(dp[curDay] != -1)
	            return dp[curDay];
	        
	        int profit = 0;
	        
	        for(int sellDay=curDay+1; sellDay<prices.length; sellDay++){
	            profit = Math.max(profit, prices[sellDay]-prices[curDay] + maxProfit1(sellDay+2, prices, dp));
	        }
	        
	        profit = Math.max(profit, maxProfit1(curDay+1, prices, dp));
	        
	        return dp[curDay] = profit;
	    }
	    
	    //state approach
	    public int maxProfit2(int[] prices){
	        int buys = Integer.MIN_VALUE;
	        int sells = 0;
	        int cool = 0;
	        
	        for(int i=0; i<prices.length; i++){
	            int psells = sells;
	            buys = Math.max(buys, cool-prices[i]);
	            sells = Math.max(sells, buys+prices[i]);
	            cool = psells;
	        }
	            
	        
	        return sells;
	    }
}
