package swordtooffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class P10_II青蛙跳台阶问题 {
    /**
     * 时间复杂度 O(N) ： 计算 f(n) 需循环 n 次，每轮循环内计算操作使用 O(1) 。
     * 空间复杂度 O(1) ： 几个标志变量使用常数大小的额外空间。
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int sum = a + b;
        for (int i = 3; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }
}
