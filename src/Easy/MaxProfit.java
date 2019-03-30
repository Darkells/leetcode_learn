package Easy;

/**
 * @author Dark
 * @date 2019/3/31 0:04
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i =0;i < prices.length-1;i++){
            for(int j = i + 1;j < prices.length;j++){
                int pricesmax = prices[j] - prices[i];
                if (pricesmax > max){
                    max = pricesmax;
                }
            }
        }
        return max;
    }
}
