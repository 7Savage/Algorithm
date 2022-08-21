package base.dp.卖股票;

import java.util.Arrays;

public class P188_买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] buys = new int[k + 1];
        int[] sells = new int[k + 1];
        Arrays.fill(buys, -prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buys[j] = Math.max(buys[j], -prices[i] + sells[j - 1]);
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        return sells[k];
    }
}
