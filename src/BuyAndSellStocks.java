public class BuyAndSellStocks {
    public static int maxProfit(int[] prices) {
        int start = prices[0], diff = 0;
        for(int i = 0; i<prices.length; i++){
            if(prices[i]<start){
                start = prices[i];
                continue;
            }
            if((prices[i]-start)>diff){
                diff = prices[i] - start;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}

