package buyandsellstock;

public class BuyAndSellWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        
        //state approach
        
        int buys = Integer.MIN_VALUE;
        int sells = 0;
        
        for(int i=0; i<prices.length; i++){
            buys = Math.max(buys, sells-prices[i]);
            sells = Math.max(sells, buys+prices[i]-fee);
        }
        
        return sells;

    }
}
