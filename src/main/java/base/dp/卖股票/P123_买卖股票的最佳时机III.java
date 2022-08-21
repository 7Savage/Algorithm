package base.dp.卖股票;

public class P123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, -prices[i] + sell1);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }
}
