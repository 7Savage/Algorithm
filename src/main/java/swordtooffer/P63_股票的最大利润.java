package swordtooffer;

public class P63_股票的最大利润 {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxPrice) {
                maxPrice = price - min;
            }
        }
        return maxPrice;
    }
}
