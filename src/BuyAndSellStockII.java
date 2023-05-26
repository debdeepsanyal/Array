public class BuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int start = prices[0], diff = 0;
        for(int i = 1; i<prices.length; i++){
            if(start<prices[i]){
                diff+=prices[i]-start;
            }
            start = prices[i];
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5,4,3,2,1}));
    }
}
