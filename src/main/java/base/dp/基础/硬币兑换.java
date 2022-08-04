package base.dp.基础;

import java.util.Arrays;

public class 硬币兑换 {

    int[] memo;

    /**
     * 自顶向下
     * 假设目标金额为 n，给定的硬币个数为 k
     * 时间复杂度：O(kn)
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    //dp 函数：dp(n) 表示，输入一个目标金额 n，返回凑出目标金额 n 所需的最少硬币数量
    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 查备忘录，防止重复计算
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem < 0) {
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return memo[amount];
    }


    public int coinChange2(int[] coins, int amount) {
        //dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1, amount 金额的硬币数最多只可能等于 amount, amount + 1 就相当于初始化为正无穷
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                if (i < coin) {
                    // 子问题无解，跳过
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
