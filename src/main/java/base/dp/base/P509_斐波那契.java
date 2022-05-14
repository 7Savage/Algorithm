package base.dp.base;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class P509_斐波那契 {

    /**
     * 暴力递归，子问题重复
     * 时间复杂度：O(2^n)
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 带备忘录的递归解法，自顶向下
     * 时间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        int[] nums = new int[n + 1];
        return helper(nums, n);
    }

    public int helper(int[] nums, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        nums[n] = helper(nums, n - 1) + helper(nums, n - 2);
        return nums[n];
    }

    /**
     * 动态规划，自底向上
     * 时间、空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib4(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp_i_1 = 1;
        int dp_i_2 = 0;

        for (int i = 2; i <= n; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        //for循环的最后一步dp_i_1被dp_i赋值
        return dp_i_1;
    }

}
