import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){return 0;}
        int count = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(coins);
        for(int coin : coins){
            list.add(coin);
        }
        while(true){
            if(amount>=list.get(list.size()-1)){
                amount-=list.get(list.size()-1);
                count++;
                if(amount==0){
                    return count;
                }
                continue;
            }
            //System.out.println(count);
            list.remove(list.size()-1);
            if(list.size()==0 && amount>0){
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1},0));
    }
}
